package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.mall.exception.BaseException;
import com.wxq.mall.model.UmsMember;
import com.wxq.mall.mapper.UmsMemberMapper;
import com.wxq.mall.model.User;
import com.wxq.mall.service.IUmsMemberService;
import com.wxq.mall.type.UserRegisterMethod;
import com.wxq.mall.type.UserStatus;
import com.wxq.mall.utils.Assert;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public void register(UmsMember user) {
        user.setCreateTime(LocalDate.now());
        user.setStatus(UserStatus.ENABLE.getStatus());
        UserRegisterMethod registerMethod = UserRegisterMethod.valueOf(user.getRegisterMethod());
        if(registerMethod == UserRegisterMethod.MOBILE) {
            User dbUser = umsMemberMapper.findByUsername(user.getPhone());
            Assert.isNull(dbUser, new BaseException("手机号已被注册"));
            // 使用手机号作用户名
            user.setUsername(user.getPhone());
        } else if(registerMethod == UserRegisterMethod.QQ) {

        } else {

        }
        umsMemberMapper.insert(user);
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
