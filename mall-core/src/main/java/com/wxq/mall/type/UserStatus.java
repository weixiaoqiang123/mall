package com.wxq.mall.type;

/**
 * @author weixiaoqiang
 * @date 2023/4/12
 *
 * 用户状态
 **/
public enum UserStatus {

    /** 禁用 */
    DISABLE(0),

    /** 启用 */
    ENABLE(1);

    private Integer status;

    UserStatus(int status){
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
