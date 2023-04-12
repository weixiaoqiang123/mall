package com.wxq.mall.service;

import com.wxq.mall.model.UmsMember;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IUmsMemberService {

    void register(UmsMember user);

    void update(UmsMember umsMember);

    void delete(String id);

    UmsMember get(String id);

    Page<UmsMember> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<UmsMember> findAll();
}
