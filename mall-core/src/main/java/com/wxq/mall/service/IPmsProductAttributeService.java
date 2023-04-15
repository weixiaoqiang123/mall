package com.wxq.mall.service;

import com.wxq.mall.model.PmsProductAttribute;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsProductAttributeService {

    void delete(String id);

    void save(String productId, List<PmsProductAttribute> pmsProductAttributes);

    List<PmsProductAttribute> findAttrsByProductId(String productId);
}
