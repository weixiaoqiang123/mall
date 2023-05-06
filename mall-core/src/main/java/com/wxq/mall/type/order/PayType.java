package com.wxq.mall.type.order;

/**
 * @author weixiaoqiang
 * @date 2023/4/22
 **/
public enum PayType {

    NO_PAY(0),

    ALI_PAY(1),

    WECHAT_PAY(2);

    private Integer type;

    PayType(int type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
