package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wxq.mall.dto.GoodsInfo;
import com.wxq.mall.dto.OrderPreInfo;
import com.wxq.mall.exception.BaseException;
import com.wxq.mall.mapper.*;
import com.wxq.mall.model.*;
import com.wxq.mall.service.IOmsOrderService;
import com.wxq.mall.type.order.OrderSourceType;
import com.wxq.mall.type.order.OrderStatus;
import com.wxq.mall.type.order.OrderType;
import com.wxq.mall.type.order.PayType;
import com.wxq.mall.type.product.ProductStatus;
import com.wxq.mall.utils.Constants;
import com.wxq.mall.utils.OrderCodeUtil;
import com.wxq.mall.utils.RabbitMqUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
@Slf4j
public class OmsOrderServiceImpl implements IOmsOrderService {

    @Resource
    private OmsOrderMapper omsOrderMapper;

    @Resource
    private UmsBusinessMapper businessMapper;

    @Resource
    private PmsProductMapper productMapper;

    @Resource
    private PmsProductStockMapper productStockMapper;

    @Resource
    private PmsProductAttributeValueMapper productAttributeValueMapper;

    @Resource
    private OmsOrderDetailMapper orderDetailMapper;

    @Resource
    private RabbitMqUtil rabbitMqUtil;

    @Override
    public void add(OmsOrder omsOrder) {
        omsOrderMapper.insert(omsOrder);
    }

    @Override
    public void update(OmsOrder omsOrder) {
        omsOrderMapper.updateById(omsOrder);
    }

    @Override
    public void delete(String id) {
        omsOrderMapper.deleteById(id);
    }

    @Override
    public OmsOrder get(String id) {
        return omsOrderMapper.selectById(id);
    }

    @Override
    public Page<OmsOrder> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return omsOrderMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<OmsOrder> findAll() {
        return omsOrderMapper.selectList(null);
    }

    /**
     * 创建订单
     *
     * 1. 根据商家将商品进行分组
     * 2. 每个商家创建一个订单基本信息
     * 3. 每个商品创建一个订单详情
     * @param orderPreInfo 订单预处理信息
     * @return 订单信息
     */
    @Override
    @Transactional
    public OmsOrder createOrder(OrderPreInfo orderPreInfo) {
        UmsBusiness business = businessMapper.findByUsername(orderPreInfo.getAccount());

        OmsOrder order = createOrderInfo(orderPreInfo);
        List<GoodsInfo> goodsInfos = orderPreInfo.getGoodsInfos();
        List<OmsOrderDetail> orderDetails = new ArrayList<>(goodsInfos.size());
        for (GoodsInfo goodsInfo : goodsInfos) {
            PmsProduct product = productMapper.selectById(goodsInfo.getProductId());
            List<PmsStockAttributeValue> attrValues = productStockMapper.findStockAttrsBySkuCode(goodsInfo.getSkuCode());
            PmsProductStock productStock = null;

            ReentrantLock lock = new ReentrantLock();
            // todo 扣件库存是否会有脏读
            // 查询库存
            try{
                // 查询库存
                productStock = productStockMapper.selectById(goodsInfo.getSkuCode());
                if(productStock.getStockNum() < goodsInfo.getShopNum()) {
                    String stockName = product.getProductName() + attrValues.stream().map(val -> val.getValueName())
                            .collect(Collectors.joining("|"));
                    throw new BaseException(stockName + "库存不足");
                }

                // 扣减库存
                int stock = productStock.getStockNum() - goodsInfo.getShopNum();
                productStock.setStockNum(stock);
                productStockMapper.updateById(productStock);
            }catch (BaseException e){
                throw e;
            } finally {
                lock.unlock();
            }

            OmsOrderDetail orderDetail = createOrderDetail(order, business, goodsInfo, product, productStock, attrValues);
            orderDetails.add(orderDetail);

            // 创建订单详情
            orderDetailMapper.insert(orderDetail);
        }

        // 创建订单
        omsOrderMapper.insert(order);
        // 发布消息
        publishOrderMessage(order.getOrderCode());
        return order;
    }

    private static OmsOrderDetail createOrderDetail(OmsOrder order, UmsBusiness business, GoodsInfo goodsInfo,
                                                    PmsProduct product, PmsProductStock stock, List<PmsStockAttributeValue> attrValues) {
        String productAttr = attrValues.stream().map(item -> item.getValueName())
                .collect(Collectors.joining("；"));

        OmsOrderDetail orderDetail = new OmsOrderDetail();
        orderDetail.setOderCode(order.getOrderCode());
        orderDetail.setProductId(product.getProductId());
        orderDetail.setProductName(product.getProductName());
        orderDetail.setSkuCode(stock.getSkuCode());
        orderDetail.setBuyNum(goodsInfo.getShopNum());
        orderDetail.setProductAttr(productAttr);
        orderDetail.setCreateTime(new Date());
        orderDetail.setOriginalPrice(stock.getPrice());
        orderDetail.setSalePrice(stock.getPrice());
        orderDetail.setBusinessCode(business.getBusinessCode());
        orderDetail.setBusinessName(business.getBusinessName());
        return orderDetail;
    }

    private static OmsOrder createOrderInfo(OrderPreInfo orderPreInfo){
        OmsOrder order = new OmsOrder();
        String orderCode = OrderCodeUtil.genCode();
        order.setAccount(orderPreInfo.getAccount());
        order.setOrderCode(orderCode);
        order.setStatus(OrderStatus.NO_PAY.getStatus());
        order.setSourceType(OrderSourceType.PC.getType());
        order.setTotalAmount(orderPreInfo.getTotalAmount());
        order.setPayAmount(orderPreInfo.getTotalAmount());
        order.setPayType(PayType.NO_PAY.getType());
        order.setOrderType(OrderType.NORMAL.getType());
        order.setCreateTime(new Date());
        return order;
    }

    private void publishOrderMessage(String orderId) {
        try {
            Connection connection = rabbitMqUtil.getConnection();
            Channel channel = connection.createChannel();
            channel.queueBind(Constants.ORDER_QUEUE, "", "");
            // 参数: 交换机名称 队列名称 传递消息参数额外设置 消息内容
            channel.basicPublish("", Constants.ORDER_QUEUE, null, orderId.getBytes(StandardCharsets.UTF_8));
        } catch (IOException | TimeoutException e) {
            log.error("publish order id message failure", e);
        }
    }
}
