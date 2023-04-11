package com.wxq.mall.service;

import com.wxq.mall.model.UmsMemberAddress;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IUmsMemberAddressService {

    void add(UmsMemberAddress umsMemberAddress);

    void update(UmsMemberAddress umsMemberAddress);

    void delete(String id);

    UmsMemberAddress get(String id);

    Page<UmsMemberAddress> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<UmsMemberAddress> findAll();
}
