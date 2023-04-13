package com.wxq.mall.type.product;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 **/
public enum ProductApproveStatus {

    /** 审核中 */
    APPROVING(0),

    /** 审核通过 */
    APPROVE_PASS(1),

    /** 审核不通过 */
    APPROVE_NOT_PASS(2);

    private int status;

    ProductApproveStatus(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
