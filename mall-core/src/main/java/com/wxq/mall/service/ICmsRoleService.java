package com.wxq.mall.service;

import com.wxq.mall.model.CmsRole;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface ICmsRoleService {

    void add(CmsRole cmsRole);

    void update(CmsRole cmsRole);

    void delete(String id);

    CmsRole get(String id);

    Page<CmsRole> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<CmsRole> findAll();
}
