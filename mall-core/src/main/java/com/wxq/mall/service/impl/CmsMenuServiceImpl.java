package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.core.TreeNode;
import com.wxq.mall.model.CmsMenu;
import com.wxq.mall.mapper.CmsMenuMapper;
import com.wxq.mall.model.CmsRole;
import com.wxq.mall.service.ICmsMenuService;
import com.wxq.mall.utils.Constants;
import com.wxq.mall.utils.SimpleKeyUtil;
import com.wxq.utils.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class CmsMenuServiceImpl implements ICmsMenuService {

    @Resource
    private CmsMenuMapper cmsMenuMapper;

    @Override
    public void add(CmsMenu cmsMenu) {
        String menuCode = SimpleKeyUtil.genShortUuId();
        if(StringUtils.isEmpty(cmsMenu.getParentMenuCode())) {
            cmsMenu.setParentMenuCode(Constants.MENU_ROOT_CODE);
        }
        cmsMenu.setMenuCode(menuCode);
        cmsMenuMapper.insert(cmsMenu);
    }

    @Override
    public void update(CmsMenu cmsMenu) {
        cmsMenuMapper.updateById(cmsMenu);
    }

    @Override
    public void delete(String id) {
        cmsMenuMapper.deleteById(id);
    }

    @Override
    public CmsMenu get(String id) {
        return cmsMenuMapper.selectById(id);
    }

    @Override
    public List<TreeNode> findMenuTree() {
        List<CmsMenu> menus = cmsMenuMapper.findAll();
        return TreeUtils.buildTree(menus).getChildren();
    }

    @Override
    @Transactional
    public void saveMenuRoles(String menuId, List<CmsRole> roles) {
        cmsMenuMapper.deleteMenuRoleMapByMenuId(menuId);
        for (CmsRole role : roles) {
            cmsMenuMapper.addMenuRoleMap(menuId, role.getRoleId());
        }
    }

    @Override
    public List<CmsMenu> findLastLevelMenus() {
        return cmsMenuMapper.findLastLevelMenus();
    }
}
