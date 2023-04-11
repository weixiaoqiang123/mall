package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.UmsMember;
import com.wxq.mall.mapper.UmsMemberMapper;
import com.wxq.mall.service.IUmsMemberService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class UmsMemberServiceImpl implements IUmsMemberService {

    @Resource
    private UmsMemberMapper umsMemberMapper;

    @Override
    public void add(UmsMember umsMember) {
        umsMemberMapper.insert(umsMember);
    }

    @Override
    public void update(UmsMember umsMember) {
        umsMemberMapper.updateById(umsMember);
    }

    @Override
    public void delete(String id) {
        umsMemberMapper.deleteById(id);
    }

    @Override
    public UmsMember get(String id) {
        return umsMemberMapper.selectById(id);
    }

    @Override
    public Page<UmsMember> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return umsMemberMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<UmsMember> findAll() {
        return umsMemberMapper.selectList(null);
    }
}
