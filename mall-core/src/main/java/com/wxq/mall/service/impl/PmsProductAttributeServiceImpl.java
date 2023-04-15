package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.mall.mapper.PmsProductAttributeMapper;
import com.wxq.mall.model.PmsProductAttribute;
import com.wxq.mall.service.IPmsProductAttributeService;
import com.wxq.mall.service.IPmsProductAttributeValueService;
import com.wxq.mall.utils.SimpleKeyUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductAttributeServiceImpl implements IPmsProductAttributeService {

    @Resource
    private PmsProductAttributeMapper productAttributeMapper;

    @Resource
    private IPmsProductAttributeValueService productAttrValueService;

    @Override
    @Transactional
    public void save(String productId, List<PmsProductAttribute> attrs) {
        productAttributeMapper.deleteAttrByProductId(productId);
        for (PmsProductAttribute attr : attrs) {
            String attrId = SimpleKeyUtil.genShortUuId();
            attr.setAttrId(attrId);
            attr.getAttrValues().forEach(attrValue -> attrValue.setAttributeId(attrId));

            // 保存属性
            productAttributeMapper.insert(attr);
            // 保存属性值
            productAttrValueService.save(productId, attr.getAttrValues());
        }
    }

    @Override
    public List<PmsProductAttribute> findAttrsByProductId(String productId) {
        return productAttributeMapper.findAttrsByProductId(productId);
    }
}
