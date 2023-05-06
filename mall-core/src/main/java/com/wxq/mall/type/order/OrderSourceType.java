package com.wxq.mall.type.order;


/**
 * @author weixiaoqiang
 * @date 2023/4/22
 *
 * 订单来源类型
 **/
public enum OrderSourceType {

    /** pc */
    PC(1),

    /** 手机 */
    MOBILE(2);

    private int type;

    OrderSourceType(int type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
