package com.wxq.mall.mapper;

import com.wxq.mall.model.CmsRole;
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
public interface CmsRoleMapper extends BaseMapper<CmsRole> {

    Page<CmsRole> findByPage(Page<CmsRole> page, @Param("params") Map<String, Object> params);

    List<CmsRole> findAll();
}
