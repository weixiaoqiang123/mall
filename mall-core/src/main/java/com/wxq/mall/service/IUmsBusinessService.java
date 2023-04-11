package com.wxq.mall.service;

import com.wxq.mall.model.UmsBusiness;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IUmsBusinessService {

    void add(UmsBusiness umsBusiness);

    void update(UmsBusiness umsBusiness);

    void delete(String id);

    UmsBusiness get(String id);

    Page<UmsBusiness> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<UmsBusiness> findAll();
}
