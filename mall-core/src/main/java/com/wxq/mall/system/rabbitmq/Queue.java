package com.wxq.mall.system.rabbitmq;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023/4/25
 **/
@Getter
public class Queue {

    private Queue() {}

    public Queue(String name){
        this.name = name;
    }

    private String name;

    private boolean durable;

    private boolean exclusive;

    private boolean autoDelete;

    private Map<String, Object> params = new HashMap<>();

    public Queue durable(boolean durable) {
        this.durable = durable;
        return this;
    }

    public Queue exclusive(boolean exclusive) {
        this.exclusive = exclusive;
        return this;
    }

    public Queue autoDelete(boolean exclusive) {
        this.exclusive = exclusive;
        return this;
    }

    public Queue addParams(String key, Object val) {
        this.params.put(key, val);
        return this;
    }
}
