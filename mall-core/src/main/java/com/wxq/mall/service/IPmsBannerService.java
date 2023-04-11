package com.wxq.mall.service;

import com.wxq.mall.model.PmsBanner;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsBannerService {

    void add(PmsBanner pmsBanner);

    void update(PmsBanner pmsBanner);

    void delete(String id);

    PmsBanner get(String id);

    Page<PmsBanner> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<PmsBanner> findAll();
}
