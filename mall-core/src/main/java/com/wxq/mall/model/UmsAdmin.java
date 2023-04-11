package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("ums_admin")
@ApiModel(value = "UmsAdmin对象", description = "管理员用户表")
public class UmsAdmin extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "UmsAdmin{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", nickname=" + nickname +
            ", headImg=" + headImg +
            ", registerMethod=" + registerMethod +
            ", phone=" + phone +
            ", email=" + email +
            ", createTime=" + createTime +
            ", status=" + status +
            ", loginTime=" + loginTime +
        "}";
    }
}
