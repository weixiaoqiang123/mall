package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.UmsAdminLoginLog;
import com.wxq.mall.mapper.UmsAdminLoginLogMapper;
import com.wxq.mall.service.IUmsAdminLoginLogService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class UmsAdminLoginLogServiceImpl implements IUmsAdminLoginLogService {

    @Resource
    private UmsAdminLoginLogMapper umsAdminLoginLogMapper;

    @Override
    public void add(UmsAdminLoginLog umsAdminLoginLog) {
        umsAdminLoginLogMapper.insert(umsAdminLoginLog);
    }

    @Override
    public void update(UmsAdminLoginLog umsAdminLoginLog) {
        umsAdminLoginLogMapper.updateById(umsAdminLoginLog);
    }

    @Override
    public void delete(String id) {
        umsAdminLoginLogMapper.deleteById(id);
    }

    @Override
    public UmsAdminLoginLog get(String id) {
        return umsAdminLoginLogMapper.selectById(id);
    }

    @Override
    public Page<UmsAdminLoginLog> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return umsAdminLoginLogMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<UmsAdminLoginLog> findAll() {
        return umsAdminLoginLogMapper.selectList(null);
    }
}
