package com.wxq.mall.type;

/**
 * @author weixiaoqiang
 * @date 2023/4/12
 *
 * 用户注册方式
 **/
public enum UserRegisterMethod {

    MOBILE("mobile"),

    QQ("qq"),

    WECHAT("wechat");

    private String method;

    UserRegisterMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
