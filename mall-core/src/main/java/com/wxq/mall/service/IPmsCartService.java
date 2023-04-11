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

    void update(PmsCart pmsCart);

    void delete(String id);

    PmsCart get(String id);

    Page<PmsCart> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<PmsCart> findAll();
}
