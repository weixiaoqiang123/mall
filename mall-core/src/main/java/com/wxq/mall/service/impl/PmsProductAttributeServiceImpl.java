package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductAttribute;
import com.wxq.mall.mapper.PmsProductAttributeMapper;
import com.wxq.mall.service.IPmsProductAttributeService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductAttributeServiceImpl implements IPmsProductAttributeService {

    @Resource
    private PmsProductAttributeMapper pmsProductAttributeMapper;

    @Override
    public void add(PmsProductAttribute pmsProductAttribute) {
        pmsProductAttributeMapper.insert(pmsProductAttribute);
    }

    @Override
    public void update(PmsProductAttribute pmsProductAttribute) {
        pmsProductAttributeMapper.updateById(pmsProductAttribute);
    }

    @Override
    public void delete(String id) {
        pmsProductAttributeMapper.deleteById(id);
    }

    @Override
    public PmsProductAttribute get(String id) {
        return pmsProductAttributeMapper.selectById(id);
    }

    @Override
    public Page<PmsProductAttribute> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return pmsProductAttributeMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<PmsProductAttribute> findAll() {
        return pmsProductAttributeMapper.selectList(null);
    }
}
