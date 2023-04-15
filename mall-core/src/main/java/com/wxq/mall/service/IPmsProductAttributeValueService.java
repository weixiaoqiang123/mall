package com.wxq.mall.service;

import com.wxq.mall.model.PmsProductAttributeValue;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsProductAttributeValueService {

    List<PmsProductAttributeValue> findAttrValuesByProductId(String productId);

    void save(String productId, List<PmsProductAttributeValue> pmsProductAttributeValue);
}
