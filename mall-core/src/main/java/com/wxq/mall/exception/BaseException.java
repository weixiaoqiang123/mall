package com.wxq.mall.exception;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable e){
        super(message, e);
    }
}
