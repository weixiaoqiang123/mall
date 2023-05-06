package com.wxq.mall.system.rabbitmq;

import lombok.Data;

/**
 * @author weixiaoqiang
 * @date 2023/4/25
 **/
public class Exchange {

    private Exchange(){}

    public Exchange(String exchangeName, String exchangeType) {
        this.exchangeName = exchangeName;
        this.exchangeType = exchangeType;
    }

    private String exchangeName;

    private String exchangeType = "direct";

    public String getExchangeName() {
        return exchangeName;
    }

    public String getExchangeType() {
        return exchangeType;
    }
}
