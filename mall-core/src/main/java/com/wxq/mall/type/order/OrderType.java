package com.wxq.mall.type.order;

/**
 * @author weixiaoqiang
 * @date 2023/4/22
 *
 * 订单类型
 **/
public enum OrderType {

    /** 普通订单 */
    NORMAL(0),

    /** 秒杀订单 */
    SEC_KILL(1);

    private Integer type;

    OrderType(int type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
