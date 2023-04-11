package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.CmsArea;
import com.wxq.mall.mapper.CmsAreaMapper;
import com.wxq.mall.service.ICmsAreaService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class CmsAreaServiceImpl implements ICmsAreaService {

    @Resource
    private CmsAreaMapper cmsAreaMapper;

    @Override
    public void add(CmsArea cmsArea) {
        cmsAreaMapper.insert(cmsArea);
    }

    @Override
    public void update(CmsArea cmsArea) {
        cmsAreaMapper.updateById(cmsArea);
    }

    @Override
    public void delete(String id) {
        cmsAreaMapper.deleteById(id);
    }

    @Override
    public CmsArea get(String id) {
        return cmsAreaMapper.selectById(id);
    }

    @Override
    public Page<CmsArea> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return cmsAreaMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<CmsArea> findAll() {
        return cmsAreaMapper.selectList(null);
    }
}
