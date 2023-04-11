package com.wxq.mall.service;

import com.wxq.mall.model.UmsAdminLoginLog;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IUmsAdminLoginLogService {

    void add(UmsAdminLoginLog umsAdminLoginLog);

    void update(UmsAdminLoginLog umsAdminLoginLog);

    void delete(String id);

    UmsAdminLoginLog get(String id);

    Page<UmsAdminLoginLog> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<UmsAdminLoginLog> findAll();
}
