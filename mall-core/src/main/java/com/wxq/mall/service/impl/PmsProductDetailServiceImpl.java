package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductDetail;
import com.wxq.mall.mapper.PmsProductDetailMapper;
import com.wxq.mall.service.IPmsProductDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductDetailServiceImpl implements IPmsProductDetailService {

    @Resource
    private PmsProductDetailMapper productDetailMapper;

    @Override
    @Transactional
    public void save(String productId, PmsProductDetail detail) {
        productDetailMapper.deleteByProductId(productId);
        productDetailMapper.insert(detail);
    }
}
