package com.wxq.mall.mapper;

import com.wxq.mall.model.CmsMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxq.mall.model.CmsRole;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Mapper
public interface CmsMenuMapper extends BaseMapper<CmsMenu> {

    Page<CmsMenu> findByPage(Page<CmsMenu> page, @Param("params") Map<String, Object> params);

    List<CmsMenu> findAll();

    void addMenuRoleMap(@Param("menuId") String menuId, @Param("roleId") String roleId);

    void deleteMenuRoleMapByMenuId(String menuId);

    List<CmsRole> findMenuRolesByMenuId(String menuId);

    List<CmsMenu> findLastLevelMenus();
}
