package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.mall.mapper.CmsRoleMapper;
import com.wxq.mall.model.CmsMenu;
import com.wxq.mall.model.CmsMenuButtonDic;
import com.wxq.mall.model.CmsRole;
import com.wxq.mall.service.ICmsRoleService;
import com.wxq.mall.utils.SimpleKeyUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class CmsRoleServiceImpl implements ICmsRoleService {

    @Resource
    private CmsRoleMapper roleMapper;

    @Override
    public void add(CmsRole cmsRole) {
        String roleId = SimpleKeyUtil.genShortUuId();
        cmsRole.setRoleId(roleId);
        roleMapper.insert(cmsRole);
    }

    @Override
    public void update(CmsRole cmsRole) {
        roleMapper.updateById(cmsRole);
    }

    @Override
    public void delete(String id) {
        roleMapper.deleteById(id);
    }

    @Override
    public CmsRole get(String id) {
        return roleMapper.selectById(id);
    }

    @Override
    public Page<CmsRole> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return roleMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<CmsRole> findAll() {
        return roleMapper.selectList(null);
    }

    @Override
    @Transactional
    public void saveRoleButtonMap(String roleId, List<Integer> buttonDicIds) {
        roleMapper.deleteRoleButtonMapByRoleId(roleId);
        for (Integer buttonDicId : buttonDicIds) {
            roleMapper.saveRoleButtonMap(roleId, buttonDicId);
        }
    }

    @Override
    public List<CmsMenu> findMenusByRoleId(String roleId) {
        return roleMapper.findMenusByRoleId(roleId);
    }

    @Override
    public List<CmsMenuButtonDic> findRoleAuthButtons(String roleId, String menuId) {
        return roleMapper.findRoleAuthButtons(roleId, menuId);
    }
}
