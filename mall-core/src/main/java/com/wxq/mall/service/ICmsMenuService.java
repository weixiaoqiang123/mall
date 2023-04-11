package com.wxq.mall.service;

import com.wxq.core.TreeNode;
import com.wxq.mall.model.CmsMenu;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxq.mall.model.CmsRole;

import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface ICmsMenuService {

    void add(CmsMenu cmsMenu);

    void update(CmsMenu cmsMenu);

    void delete(String id);

    CmsMenu get(String id);

    List<TreeNode> findMenuTree();

    void saveMenuRoles(String menuId, List<CmsRole> roles);

    List<CmsMenu> findLastLevelMenus();
}
