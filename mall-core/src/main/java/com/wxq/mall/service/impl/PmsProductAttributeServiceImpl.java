package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.mall.mapper.PmsProductAttributeMapper;
import com.wxq.mall.model.PmsProductAttribute;
import com.wxq.mall.service.IPmsProductAttributeService;
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

    @Override
    public void delete(String id) {
        productAttributeMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void save(String productId, List<PmsProductAttribute> pmsProductAttributes) {
        productAttributeMapper.deleteAttrByProductId(productId);
        for (PmsProductAttribute pmsProductAttribute : pmsProductAttributes) {
            String attrId = SimpleKeyUtil.genShortUuId(8);
            pmsProductAttribute.setAttrId(attrId);
            productAttributeMapper.insert(pmsProductAttribute);
        }
    }

    @Override
    public List<PmsProductAttribute> findAttrsByProductId(String productId) {
        return productAttributeMapper.findAttrsByProductId(productId);
    }
}
