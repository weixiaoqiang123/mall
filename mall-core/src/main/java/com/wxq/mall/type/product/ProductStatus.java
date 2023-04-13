package com.wxq.mall.type.product;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 *
 * 商品状态
 **/
public enum ProductStatus {

    EDIT(0),

    PUBLISH(1),

    OFF_LINE(2);

    private int status;

    ProductStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
