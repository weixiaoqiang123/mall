package com.wxq.mall.mapper;

import com.wxq.mall.model.UmsAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {

    UmsAdmin findByUsername(String username);

    Page<UmsAdmin> findByPage(Page<UmsAdmin> page, @Param("params") Map<String, Object> params);

    List<UmsAdmin> findAll();

    List<UmsAdmin> findByRoleId(String roleId);
}
