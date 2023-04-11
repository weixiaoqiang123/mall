package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductStock;
import com.wxq.mall.mapper.PmsProductStockMapper;
import com.wxq.mall.service.IPmsProductStockService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductStockServiceImpl implements IPmsProductStockService {

    @Resource
    private PmsProductStockMapper pmsProductStockMapper;

    @Override
    public void add(PmsProductStock pmsProductStock) {
        pmsProductStockMapper.insert(pmsProductStock);
    }

    @Override
    public void update(PmsProductStock pmsProductStock) {
        pmsProductStockMapper.updateById(pmsProductStock);
    }

    @Override
    public void delete(String id) {
        pmsProductStockMapper.deleteById(id);
    }

    @Override
    public PmsProductStock get(String id) {
        return pmsProductStockMapper.selectById(id);
    }

    @Override
    public Page<PmsProductStock> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return pmsProductStockMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<PmsProductStock> findAll() {
        return pmsProductStockMapper.selectList(null);
    }
}
