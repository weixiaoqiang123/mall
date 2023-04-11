package com.wxq.mall.service;

import com.wxq.mall.model.OmsOrder;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IOmsOrderService {

    void add(OmsOrder omsOrder);

    void update(OmsOrder omsOrder);

    void delete(String id);

    OmsOrder get(String id);

    Page<OmsOrder> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<OmsOrder> findAll();
}
