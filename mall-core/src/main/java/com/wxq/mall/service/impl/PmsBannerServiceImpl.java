package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.PmsBanner;
import com.wxq.mall.mapper.PmsBannerMapper;
import com.wxq.mall.service.IPmsBannerService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsBannerServiceImpl implements IPmsBannerService {

    @Resource
    private PmsBannerMapper pmsBannerMapper;

    @Override
    public void add(PmsBanner pmsBanner) {
        pmsBannerMapper.insert(pmsBanner);
    }

    @Override
    public void update(PmsBanner pmsBanner) {
        pmsBannerMapper.updateById(pmsBanner);
    }

    @Override
    public void delete(String id) {
        pmsBannerMapper.deleteById(id);
    }

    @Override
    public PmsBanner get(String id) {
        return pmsBannerMapper.selectById(id);
    }

    @Override
    public Page<PmsBanner> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return pmsBannerMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<PmsBanner> findAll() {
        return pmsBannerMapper.selectList(null);
    }
}
