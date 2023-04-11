package com.wxq.common.model;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
public class ErrorCode {

    /**
     * 成功
     */
    public static final int SUCCESS = 1;

    /**
     * 失败
     */
    public static final int FAIL = 0;

    /**
     * 通用异常
     */
    public static final int COMMON_ERROR = 2;

    /**
     * 登陆，验证失败
     */
    public static final int LOGIN_WRONG = 30001;


    /**
     * 服务期异常code
     */
    public static final int SERVER_EXCEPTION_CODE = 500;

}
