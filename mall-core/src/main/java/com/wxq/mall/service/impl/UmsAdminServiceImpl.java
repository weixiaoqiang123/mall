package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.UmsAdmin;
import com.wxq.mall.mapper.UmsAdminMapper;
import com.wxq.mall.service.IUmsAdminService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class UmsAdminServiceImpl implements IUmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Override
    public void add(UmsAdmin umsAdmin) {
        umsAdminMapper.insert(umsAdmin);
    }

    @Override
    public void update(UmsAdmin umsAdmin) {
        umsAdminMapper.updateById(umsAdmin);
    }

    @Override
    public void delete(String id) {
        umsAdminMapper.deleteById(id);
    }

    @Override
    public UmsAdmin get(String id) {
        return umsAdminMapper.selectById(id);
    }

    @Override
    public Page<UmsAdmin> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return umsAdminMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<UmsAdmin> findAll() {
        return umsAdminMapper.selectList(null);
    }
}
