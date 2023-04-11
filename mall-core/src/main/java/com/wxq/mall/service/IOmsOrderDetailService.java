package com.wxq.mall.service;

import com.wxq.mall.model.OmsOrderDetail;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IOmsOrderDetailService {

    void add(OmsOrderDetail omsOrderDetail);

    void update(OmsOrderDetail omsOrderDetail);

    void delete(String id);

    OmsOrderDetail get(String id);

    Page<OmsOrderDetail> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<OmsOrderDetail> findAll();
}
