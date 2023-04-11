package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductImages;
import com.wxq.mall.mapper.PmsProductImagesMapper;
import com.wxq.mall.service.IPmsProductImagesService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductImagesServiceImpl implements IPmsProductImagesService {

    @Resource
    private PmsProductImagesMapper pmsProductImagesMapper;

    @Override
    public void add(PmsProductImages pmsProductImages) {
        pmsProductImagesMapper.insert(pmsProductImages);
    }

    @Override
    public void update(PmsProductImages pmsProductImages) {
        pmsProductImagesMapper.updateById(pmsProductImages);
    }

    @Override
    public void delete(String id) {
        pmsProductImagesMapper.deleteById(id);
    }

    @Override
    public PmsProductImages get(String id) {
        return pmsProductImagesMapper.selectById(id);
    }

    @Override
    public Page<PmsProductImages> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return pmsProductImagesMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<PmsProductImages> findAll() {
        return pmsProductImagesMapper.selectList(null);
    }
}
