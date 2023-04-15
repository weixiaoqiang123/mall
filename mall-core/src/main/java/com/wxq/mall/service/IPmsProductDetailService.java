package com.wxq.mall.service;

import com.wxq.mall.model.PmsProductDetail;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsProductDetailService {

    void save(String productId, PmsProductDetail detail);
}
