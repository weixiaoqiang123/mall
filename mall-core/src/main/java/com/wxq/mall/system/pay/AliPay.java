package com.wxq.mall.system.pay;

/**
 * @author weixiaoqiang
 * @date 2023/4/16
 **/
public class AliPay implements PayMethod {

    private static final String ACTION_URL = "/payment/alipay";

    @Override
    public String actionUrl() {
        return ACTION_URL;
    }
}
