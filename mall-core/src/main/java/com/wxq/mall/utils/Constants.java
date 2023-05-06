package com.wxq.mall.utils;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
public class Constants {

    // token 过期时间
    public static final int TOKEN_EXPIRE_TIME = 2 * 60 * 60;
    // 后台登录用户key
    public static final String USER = "user";
    public static final String BUSINESS = "business";
    // token请求头
    public static final String TOKEN_HEADER = "Authorization";
    // menu root
    public static final String MENU_ROOT_CODE = "-1";
    // area root
    public static final String AREA_ROOT_CODE = "100000";
    // 商品审核角色
    public static final String APPROVAL_ROLE_ID = "";

    public static final String PAY_RESULT_EXCHANGE = "pay-result";
    // 支付成功消息队列名称
    public static final String PAY_SUCCESS_QUEUE = "pay-success";
    // 订单队列
    public static final String ORDER_QUEUE = "order";
    // 订单过期时间 30分钟
    public static final int ORDER_EXPIRE_TIME = 30 * 60 * 1000;
    // 订单超时队列
    public static final String ORDER_TIME_OUT_QUEUE = "order-time-out";
}
