package com.wxq.mall.system;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 **/
public class MessageWrapper {

    public MessageWrapper(String message) {
        this.message = message;
    }

    public MessageWrapper(String message, boolean isRead) {
        this.message = message;
        this.isRead = isRead;
    }

    private String message;

    private boolean isRead = false;

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }
}
