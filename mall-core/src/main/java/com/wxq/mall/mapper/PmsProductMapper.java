package com.wxq.mall.mapper;

import com.wxq.mall.model.PmsProduct;
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
public interface PmsProductMapper extends BaseMapper<PmsProduct> {

    Page<PmsProduct> findByPage(Page<PmsProduct> page, @Param("params") Map<String, Object> params);

    List<PmsProduct> findAll();
}
