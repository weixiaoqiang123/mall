package com.wxq.mall.system.rabbitmq;

import lombok.Data;

/**
 * @author weixiaoqiang
 * @date 2023/4/25
 **/
@Data
public class Binding {

    public Binding(String queueName, String exchangeName) {
        this.queueName = queueName;
        this.exchangeName = exchangeName;
    }

    private String queueName;

    private String exchangeName;
}
