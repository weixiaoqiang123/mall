package com.wxq.mall.service;

import com.wxq.mall.model.PmsProductStock;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsProductStockService {

    void add(PmsProductStock pmsProductStock);

    void update(PmsProductStock pmsProductStock);

    void delete(String id);

    PmsProductStock get(String id);

    Page<PmsProductStock> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<PmsProductStock> findAll();
}
