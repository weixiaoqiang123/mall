package com.wxq.mall.system.pay;

import com.wxq.mall.exception.BaseException;

/**
 * @author weixiaoqiang
 * @date 2023/4/16
 **/
public class WeChatPay implements PayMethod {

    @Override
    public String actionUrl() {
        throw new BaseException("not support");
    }
}
