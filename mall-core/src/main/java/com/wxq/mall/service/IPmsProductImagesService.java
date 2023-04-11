package com.wxq.mall.service;

import com.wxq.mall.model.PmsProductImages;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsProductImagesService {

    void add(PmsProductImages pmsProductImages);

    void update(PmsProductImages pmsProductImages);

    void delete(String id);

    PmsProductImages get(String id);

    Page<PmsProductImages> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<PmsProductImages> findAll();
}
