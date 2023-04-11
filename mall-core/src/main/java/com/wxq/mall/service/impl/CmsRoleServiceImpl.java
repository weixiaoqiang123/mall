package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.CmsRole;
import com.wxq.mall.mapper.CmsRoleMapper;
import com.wxq.mall.service.ICmsRoleService;
import com.wxq.mall.utils.SimpleKeyUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class CmsRoleServiceImpl implements ICmsRoleService {

    @Resource
    private CmsRoleMapper cmsRoleMapper;

    @Override
    public void add(CmsRole cmsRole) {
        String roleId = SimpleKeyUtil.genShortUuId();
        cmsRole.setRoleId(roleId);
        cmsRoleMapper.insert(cmsRole);
    }

    @Override
    public void update(CmsRole cmsRole) {
        cmsRoleMapper.updateById(cmsRole);
    }

    @Override
    public void delete(String id) {
        cmsRoleMapper.deleteById(id);
    }

    @Override
    public CmsRole get(String id) {
        return cmsRoleMapper.selectById(id);
    }

    @Override
    public Page<CmsRole> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return cmsRoleMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<CmsRole> findAll() {
        return cmsRoleMapper.selectList(null);
    }
}
