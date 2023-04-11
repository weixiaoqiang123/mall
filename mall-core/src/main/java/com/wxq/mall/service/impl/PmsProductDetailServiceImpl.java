package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductDetail;
import com.wxq.mall.mapper.PmsProductDetailMapper;
import com.wxq.mall.service.IPmsProductDetailService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductDetailServiceImpl implements IPmsProductDetailService {

    @Resource
    private PmsProductDetailMapper pmsProductDetailMapper;

    @Override
    public void add(PmsProductDetail pmsProductDetail) {
        pmsProductDetailMapper.insert(pmsProductDetail);
    }

    @Override
    public void update(PmsProductDetail pmsProductDetail) {
        pmsProductDetailMapper.updateById(pmsProductDetail);
    }

    @Override
    public void delete(String id) {
        pmsProductDetailMapper.deleteById(id);
    }

    @Override
    public PmsProductDetail get(String id) {
        return pmsProductDetailMapper.selectById(id);
    }

    @Override
    public Page<PmsProductDetail> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return pmsProductDetailMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<PmsProductDetail> findAll() {
        return pmsProductDetailMapper.selectList(null);
    }
}
