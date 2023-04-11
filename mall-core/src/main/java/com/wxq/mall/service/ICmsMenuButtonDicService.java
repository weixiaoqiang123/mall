package com.wxq.mall.service;

import com.wxq.mall.model.CmsMenuButtonDic;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface ICmsMenuButtonDicService {

    void add(CmsMenuButtonDic cmsMenuButtonDic);

    void update(CmsMenuButtonDic cmsMenuButtonDic);

    void delete(String id);

    CmsMenuButtonDic get(String id);

    Page<Map<String, String>> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<CmsMenuButtonDic> findAll();

    void checkCurrentMenuButtonIdUnique(String menuId, String buttonId);
}
