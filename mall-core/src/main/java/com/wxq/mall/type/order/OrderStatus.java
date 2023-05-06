package com.wxq.mall.type.order;

/**
 * @author weixiaoqiang
 * @date 2023/4/15
 **/
public enum OrderStatus {

    /** 未支付 */
    NO_PAY(0),

    /** 待发货 */
    WAIT_DELIVER(1),

    /** 已发货 */
    DELIVERED(2),

    /** 已收货 */
    RECEIVED(3),

    /** 已取消 */
    CANCELED(4);

    private int status;

    OrderStatus(int status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
