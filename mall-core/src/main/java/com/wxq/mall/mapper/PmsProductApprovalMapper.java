package com.wxq.mall.mapper;

import com.wxq.mall.model.PmsProductApproval;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-13
 */
@Mapper
public interface PmsProductApprovalMapper extends BaseMapper<PmsProductApproval> {

    Page<PmsProductApproval> findByPage(Page<PmsProductApproval> page, @Param("params") Map<String, Object> params);

    List<PmsProductApproval> findAll();
}
