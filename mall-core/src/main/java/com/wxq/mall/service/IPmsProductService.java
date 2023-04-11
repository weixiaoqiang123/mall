package com.wxq.mall.service;

import com.wxq.mall.model.PmsProduct;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsProductService {

    void add(PmsProduct pmsProduct);

    void update(PmsProduct pmsProduct);

    void delete(String id);

    PmsProduct get(String id);

    Page<PmsProduct> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<PmsProduct> findAll();
}
