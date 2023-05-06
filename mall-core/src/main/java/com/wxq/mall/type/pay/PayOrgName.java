package com.wxq.mall.type.pay;

/**
 * @author weixiaoqiang
 * @date 2023/4/16
 **/
public enum PayOrgName {

    WECHAT("wechat"),

    ALIPAY("alipay");

    private String payOrgName;

    PayOrgName(String payOrgName) {
        this.payOrgName = payOrgName;
    }

    public String getPayOrgName() {
        return payOrgName;
    }
}
