package com.wxq.mall.service;

import com.wxq.mall.model.PmsProductAttribute;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsProductAttributeService {

    void save(String productId, List<PmsProductAttribute> productAttrs);

    List<PmsProductAttribute> findAttrsByProductId(String productId);
}
