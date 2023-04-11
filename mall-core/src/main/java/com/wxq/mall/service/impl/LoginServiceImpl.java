package com.wxq.mall.service.impl;

import com.wxq.mall.exception.BaseException;
import com.wxq.mall.mapper.UmsAdminMapper;
import com.wxq.mall.mapper.UmsMemberMapper;
import com.wxq.mall.model.User;
import com.wxq.mall.service.LoginService;
import com.wxq.mall.utils.Constants;
import com.wxq.mall.utils.JwtUtil;
import com.wxq.mall.utils.RequestHolder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UmsAdminMapper adminMapper;

    @Resource
    private UmsMemberMapper memberMapper;

    @Override
    public String loginAdmin(String username, String password) {
        User user = adminMapper.findByUsername(username);
        checkUserInfoAndStore(user, password, Constants.ADMIN_USER);
        return JwtUtil.createToken(username, Constants.TOKEN_EXPIRE_TIME);
    }

    @Override
    public String login(String username, String password) {
        User user = memberMapper.findByUsername(username);
        checkUserInfoAndStore(user, password, Constants.USER);
        return JwtUtil.createToken(username, Constants.TOKEN_EXPIRE_TIME);
    }

    @Override
    public void logoutAdmin() {
        RequestHolder.getSession().removeAttribute(Constants.ADMIN_USER);
    }

    @Override
    public void logout() {
        RequestHolder.getSession().removeAttribute(Constants.USER);
    }

    private void checkUserInfoAndStore(User user, String password, String key){
        if(user == null){
            throw new BaseException("用户不存在");
        }

        if(!user.getPassword().equals(password)){
            throw new BaseException("密码错误");
        }
        // 存储用户信息
        RequestHolder.getSession().setAttribute(key, user);
    }
}
