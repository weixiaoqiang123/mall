package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.UmsBusiness;
import com.wxq.mall.mapper.UmsBusinessMapper;
import com.wxq.mall.service.IUmsBusinessService;
import com.wxq.mall.utils.SimpleKeyUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class UmsBusinessServiceImpl implements IUmsBusinessService {

    @Resource
    private UmsBusinessMapper umsBusinessMapper;

    @Override
    public void add(UmsBusiness umsBusiness) {
        String businessCode = SimpleKeyUtil.genUUID();
        umsBusiness.setBusinessCode(businessCode);
        umsBusiness.setCreateTime(new Date());
        umsBusinessMapper.insert(umsBusiness);
    }

    @Override
    public void update(UmsBusiness umsBusiness) {
        umsBusinessMapper.updateById(umsBusiness);
    }

    @Override
    public void delete(String id) {
        umsBusinessMapper.deleteById(id);
    }

    @Override
    public UmsBusiness get(String id) {
        return umsBusinessMapper.selectById(id);
    }

    @Override
    public Page<UmsBusiness> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return umsBusinessMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<UmsBusiness> findAll() {
        return umsBusinessMapper.selectList(null);
    }
}
