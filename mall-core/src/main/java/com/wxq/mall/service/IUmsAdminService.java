package com.wxq.mall.service;

import com.wxq.mall.model.UmsAdmin;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IUmsAdminService {

    void add(UmsAdmin umsAdmin);

    void update(UmsAdmin umsAdmin);

    void delete(String id);

    UmsAdmin get(String id);

    Page<UmsAdmin> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<UmsAdmin> findAll();
}
