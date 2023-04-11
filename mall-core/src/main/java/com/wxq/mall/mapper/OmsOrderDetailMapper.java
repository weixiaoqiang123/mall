package com.wxq.mall.mapper;

import com.wxq.mall.model.OmsOrderDetail;
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
public interface OmsOrderDetailMapper extends BaseMapper<OmsOrderDetail> {

    Page<OmsOrderDetail> findByPage(Page<OmsOrderDetail> page, @Param("params") Map<String, Object> params);

    List<OmsOrderDetail> findAll();
}
