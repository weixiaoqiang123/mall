package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.mapper.PmsProductAttributeValueMapper;
import com.wxq.mall.model.PmsProductAttributeValue;
import com.wxq.mall.service.IPmsProductAttributeValueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductAttributeValueServiceImpl implements IPmsProductAttributeValueService {

    @Resource
    private PmsProductAttributeValueMapper productAttributeValueMapper;

    @Override
    public List<PmsProductAttributeValue> findAttrValuesByProductId(String productId) {
        return productAttributeValueMapper.findAttrValuesByProductId(productId);
    }

    @Override
    @Transactional
    public void save(String productId, List<PmsProductAttributeValue> pmsProductAttributeValue) {
        productAttributeValueMapper.deleteAttrValuesByProductId(productId);
        for (PmsProductAttributeValue productAttributeValue : pmsProductAttributeValue) {
            productAttributeValueMapper.insert(productAttributeValue);
        }
    }
}
