package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.PmsProduct;
import com.wxq.mall.mapper.PmsProductMapper;
import com.wxq.mall.service.IPmsProductService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductServiceImpl implements IPmsProductService {

    @Resource
    private PmsProductMapper pmsProductMapper;

    @Override
    public void add(PmsProduct pmsProduct) {
        pmsProductMapper.insert(pmsProduct);
    }

    @Override
    public void update(PmsProduct pmsProduct) {
        pmsProductMapper.updateById(pmsProduct);
    }

    @Override
    public void delete(String id) {
        pmsProductMapper.deleteById(id);
    }

    @Override
    public PmsProduct get(String id) {
        return pmsProductMapper.selectById(id);
    }

    @Override
    public Page<PmsProduct> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return pmsProductMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<PmsProduct> findAll() {
        return pmsProductMapper.selectList(null);
    }
}
