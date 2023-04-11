package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductAttributeValue;
import com.wxq.mall.mapper.PmsProductAttributeValueMapper;
import com.wxq.mall.service.IPmsProductAttributeValueService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductAttributeValueServiceImpl implements IPmsProductAttributeValueService {

    @Resource
    private PmsProductAttributeValueMapper pmsProductAttributeValueMapper;

    @Override
    public void add(PmsProductAttributeValue pmsProductAttributeValue) {
        pmsProductAttributeValueMapper.insert(pmsProductAttributeValue);
    }

    @Override
    public void update(PmsProductAttributeValue pmsProductAttributeValue) {
        pmsProductAttributeValueMapper.updateById(pmsProductAttributeValue);
    }

    @Override
    public void delete(String id) {
        pmsProductAttributeValueMapper.deleteById(id);
    }

    @Override
    public PmsProductAttributeValue get(String id) {
        return pmsProductAttributeValueMapper.selectById(id);
    }

    @Override
    public Page<PmsProductAttributeValue> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return pmsProductAttributeValueMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<PmsProductAttributeValue> findAll() {
        return pmsProductAttributeValueMapper.selectList(null);
    }
}
