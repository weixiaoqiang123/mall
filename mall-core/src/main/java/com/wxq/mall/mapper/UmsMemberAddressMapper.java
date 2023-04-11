package com.wxq.mall.mapper;

import com.wxq.mall.model.UmsMemberAddress;
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
public interface UmsMemberAddressMapper extends BaseMapper<UmsMemberAddress> {

    Page<UmsMemberAddress> findByPage(Page<UmsMemberAddress> page, @Param("params") Map<String, Object> params);

    List<UmsMemberAddress> findAll();
}
