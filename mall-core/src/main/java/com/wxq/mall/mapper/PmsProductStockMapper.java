package com.wxq.mall.mapper;

import com.wxq.mall.model.PmsProductStock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxq.mall.model.PmsStockAttributeValue;
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
public interface PmsProductStockMapper extends BaseMapper<PmsProductStock> {

    Page<PmsProductStock> findByPage(Page<PmsProductStock> page, @Param("params") Map<String, Object> params);

    List<PmsProductStock> findAll();

    List<PmsStockAttributeValue> findStockAttrsBySkuCode(String skuCode);
}
