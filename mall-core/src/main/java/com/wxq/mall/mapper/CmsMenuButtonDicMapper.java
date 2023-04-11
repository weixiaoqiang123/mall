package com.wxq.mall.mapper;

import com.wxq.mall.model.CmsMenuButtonDic;
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
public interface CmsMenuButtonDicMapper extends BaseMapper<CmsMenuButtonDic> {

    Page<Map<String, String>> findByPage(Page<CmsMenuButtonDic> page, @Param("params") Map<String, Object> params);

    List<CmsMenuButtonDic> findAll();

    CmsMenuButtonDic findDic(@Param("menuId") String menuId, @Param("buttonId") String buttonId);
}
