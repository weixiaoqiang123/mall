package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.mall.exception.BaseException;
import com.wxq.mall.model.UmsAdmin;
import com.wxq.mall.mapper.UmsAdminMapper;
import com.wxq.mall.model.User;
import com.wxq.mall.service.IUmsAdminService;
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
public class UmsAdminServiceImpl implements IUmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Override
    public void register(UmsAdmin user) {
        user.setCreateTime(LocalDate.now());
        user.setStatus(UserStatus.ENABLE.getStatus());
        UserRegisterMethod registerMethod = UserRegisterMethod.valueOf(user.getRegisterMethod());
        if(registerMethod == UserRegisterMethod.MOBILE) {
            User dbUser = umsAdminMapper.findByUsername(user.getPhone());
            Assert.isNull(dbUser, new BaseException("手机号已被注册"));
            // 使用手机号作用户名
            user.setUsername(user.getPhone());
        } else if(registerMethod == UserRegisterMethod.QQ) {

        } else {

        }
    }

    @Override
    public void update(UmsAdmin umsAdmin) {
        umsAdminMapper.updateById(umsAdmin);
    }

    @Override
    public void delete(String id) {
        umsAdminMapper.deleteById(id);
    }

    @Override
    public UmsAdmin get(String id) {
        return umsAdminMapper.selectById(id);
    }

    @Override
    public Page<UmsAdmin> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return umsAdminMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<UmsAdmin> findAll() {
        return umsAdminMapper.selectList(null);
    }
}
