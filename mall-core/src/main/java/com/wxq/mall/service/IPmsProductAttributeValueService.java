package com.wxq.mall.service;

import com.wxq.mall.model.PmsProductAttributeValue;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsProductAttributeValueService {

    void add(PmsProductAttributeValue pmsProductAttributeValue);

    void update(PmsProductAttributeValue pmsProductAttributeValue);

    void delete(String id);

    PmsProductAttributeValue get(String id);

    Page<PmsProductAttributeValue> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<PmsProductAttributeValue> findAll();
}
