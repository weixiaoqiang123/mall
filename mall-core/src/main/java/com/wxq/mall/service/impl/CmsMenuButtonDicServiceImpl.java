package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.mall.exception.BaseException;
import com.wxq.mall.model.CmsMenuButtonDic;
import com.wxq.mall.mapper.CmsMenuButtonDicMapper;
import com.wxq.mall.service.ICmsMenuButtonDicService;
import com.wxq.mall.utils.Assert;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class CmsMenuButtonDicServiceImpl implements ICmsMenuButtonDicService {

    @Resource
    private CmsMenuButtonDicMapper cmsMenuButtonDicMapper;

    @Override
    public void add(CmsMenuButtonDic cmsMenuButtonDic) {
        cmsMenuButtonDicMapper.insert(cmsMenuButtonDic);
    }

    @Override
    public void update(CmsMenuButtonDic cmsMenuButtonDic) {
        cmsMenuButtonDicMapper.updateById(cmsMenuButtonDic);
    }

    @Override
    public void delete(String id) {
        cmsMenuButtonDicMapper.deleteById(id);
    }

    @Override
    public CmsMenuButtonDic get(String id) {
        return cmsMenuButtonDicMapper.selectById(id);
    }

    @Override
    public Page<Map<String, String>> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return cmsMenuButtonDicMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<CmsMenuButtonDic> findAll() {
        return cmsMenuButtonDicMapper.selectList(null);
    }

    @Override
    public void checkCurrentMenuButtonIdUnique(String menuId, String buttonId) {
        CmsMenuButtonDic dic = cmsMenuButtonDicMapper.findDic(menuId, buttonId);
        Assert.isNull(dic, new BaseException("当前菜单下按钮已存在"));
    }
}
