package com.wxq.mall.service;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
public interface LoginService {

    String loginAdmin(String username, String password);

    String login(String username, String password);

    void logoutAdmin();

    void logout();
}
