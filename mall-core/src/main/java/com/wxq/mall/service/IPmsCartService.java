package com.wxq.mall.service;

import com.wxq.mall.model.PmsCart;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsCartService {

    void add(PmsCart pmsCart);

    void delete(String id);

    PmsCart get(String id);

    /**
     *
     * @param params
     * @param page
     * @param size
     * @return
     * businessCode 商家编码
     * businessName 商家名称
     * cartList 购物车列表
     */
    Page<Map<String, Object>> findByPage(Map<String,Object> params, Integer page, Integer size);

    void updateCartCount(Integer id, Integer count);
}
