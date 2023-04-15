package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.mall.controller.MessageDeliver;
import com.wxq.mall.mapper.*;
import com.wxq.mall.model.*;
import com.wxq.mall.service.IPmsProductService;
import com.wxq.mall.system.MessageWrapper;
import com.wxq.mall.type.product.ProductApproveStatus;
import com.wxq.mall.type.product.ProductStatus;
import com.wxq.mall.utils.Constants;
import com.wxq.mall.utils.ProductApprovalUtil;
import com.wxq.mall.utils.RequestHolder;
import com.wxq.mall.utils.SimpleKeyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductServiceImpl implements IPmsProductService {

    @Resource
    private PmsProductMapper productMapper;

    @Resource
    private UmsBusinessMapper businessMapper;

    @Resource
    private PmsProductApprovalMapper productApprovalMapper;

    @Resource
    private MessageDeliver messageDeliver;

    @Override
    public void save(PmsProduct pmsProduct) {
        if(StringUtils.isEmpty(pmsProduct.getProductId())){
            add(pmsProduct);
        } else {
            update(pmsProduct);
        }
    }

    @Override
    public void add(PmsProduct pmsProduct) {
        String productId = SimpleKeyUtil.genUUID();
        pmsProduct.setStatus(ProductStatus.EDIT.getStatus());
        pmsProduct.setCreateTime(new Date());
        pmsProduct.setUpdateTime(new Date());
        pmsProduct.setProductId(productId);
    }

    @Override
    public void update(PmsProduct pmsProduct) {
        pmsProduct.setUpdateTime(new Date());
        productMapper.updateById(pmsProduct);
    }

    @Override
    public void delete(String id) {
        productMapper.deleteById(id);
    }

    @Override
    public PmsProduct get(String id) {
        return productMapper.selectById(id);
    }

    @Override
    public Page<PmsProduct> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return productMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<PmsProduct> findAll() {
        return productMapper.selectList(null);
    }

    @Override
    public void updateNewProductStatus(String productId, Integer status) {
        PmsProduct product = productMapper.selectById(productId);
        product.setNewStatus(status);
        productMapper.updateById(product);
    }

    @Override
    public void updateRecommendStatus(String productId, Integer status) {
        PmsProduct product = productMapper.selectById(productId);
        product.setRecommendStatus(status);
        productMapper.updateById(product);
    }

    @Override
    public void publish(String productId) {
        UmsBusiness business = (UmsBusiness) RequestHolder.getSession().getAttribute(Constants.BUSINESS);
        PmsProduct product = productMapper.selectById(productId);
        product.setStatus(ProductStatus.PUBLISH.getStatus());
        product.setPublishTime(new Date());
        productMapper.updateById(product);

        // 创建审核记录
        PmsProductApproval productApproval = createProductVerify(product, business);
        productApprovalMapper.insert(productApproval);
        String message = ProductApprovalUtil.buildApprovalMessage(business.getBusinessName(), product.getProductName());
        // 向拥有审核角色用户广播审核消息
        messageDeliver.broadcastMessage(new MessageWrapper(message));
    }

    @Override
    public void offLine(String productId) {
        PmsProduct product = productMapper.selectById(productId);
        product.setStatus(ProductStatus.OFF_LINE.getStatus());
        product.setVerifyStatus(ProductApproveStatus.APPROVING.getStatus());
        product.setOfflineTime(new Date());
    }

    @Override
    public PmsProduct getRoot(String productId) {
        return productMapper.findProductDetailInfo(productId);
    }

    private PmsProductApproval createProductVerify(PmsProduct product, UmsBusiness business){
        User user = (User) RequestHolder.getSession().getAttribute(Constants.USER);
        PmsProductApproval pmsProductApproval = new PmsProductApproval();
        pmsProductApproval.setUsername(user.getUsername());
        pmsProductApproval.setProductId(product.getProductId());
        pmsProductApproval.setProductName(product.getProductName());
        pmsProductApproval.setBusinessName(business.getBusinessName());
        pmsProductApproval.setStatus(ProductApproveStatus.APPROVING.getStatus());
        pmsProductApproval.setCreateTime(new Date());
        return pmsProductApproval;
    }
}
