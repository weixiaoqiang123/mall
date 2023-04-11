package com.wxq.mall.service;

import com.wxq.mall.model.PmsProductAttribute;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsProductAttributeService {

    void add(PmsProductAttribute pmsProductAttribute);

    void update(PmsProductAttribute pmsProductAttribute);

    void delete(String id);

    PmsProductAttribute get(String id);

    Page<PmsProductAttribute> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<PmsProductAttribute> findAll();
}
