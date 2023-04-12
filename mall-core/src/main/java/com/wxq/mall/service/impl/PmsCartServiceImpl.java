package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.mall.mapper.PmsCartMapper;
import com.wxq.mall.model.PmsCart;
import com.wxq.mall.service.IPmsCartService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsCartServiceImpl implements IPmsCartService {

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    @Resource
    private PmsCartMapper cartMapper;
    
    @Override
    public void add(PmsCart pmsCart) {
        String productId = pmsCart.getProductId();
        String skuCode = pmsCart.getSkuCode();
        String account = pmsCart.getAccount();
        PmsCart cartInfo = cartMapper.findCartInfo(productId, skuCode, account);
        if(cartInfo == null){
            pmsCart.setCreateTime(new Date());
            pmsCart.setQuantity(1);
            cartMapper.insert(pmsCart);
        } else {
            // 已存在 数量加一
            pmsCart.setUpdateTime(new Date());
            pmsCart.setQuantity(pmsCart.getQuantity() + 1);
            cartMapper.updateById(pmsCart);
        }
    }

    @Override
    public void delete(String id) {
        cartMapper.deleteById(id);
    }

    @Override
    public PmsCart get(String id) {
        return cartMapper.selectById(id);
    }

    @Override
    public Page<Map<String, Object>> findByPage(Map<String, Object> params, Integer page, Integer size) {
        // 分页查询商家信息
        Page<Map<String, Object>> pageModel = cartMapper.findByPage(new Page<>(page, size), params);
        List<Map<String, Object>> records = pageModel.getRecords();
        CountDownLatch lock = new CountDownLatch(size);
        for (Map<String, Object> businessInfo : records) {
            executor.execute(() -> {
                lock.countDown();
                String businessCode = (String) businessInfo.get("businessCode");
                List<PmsCart> cartInfos = cartMapper.findCartByBusinessCode(businessCode);
                businessInfo.put("cartList", cartInfos);
            });
        }
        try {
            lock.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pageModel;
    }

    @Override
    public void updateCartCount(Integer id, Integer count) {
        PmsCart cart = cartMapper.selectById(id);
        cart.setQuantity(count);
        cartMapper.updateById(cart);
    }
}
