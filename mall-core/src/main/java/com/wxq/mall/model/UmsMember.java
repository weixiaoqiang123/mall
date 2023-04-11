package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("ums_member")
@ApiModel(value = "UmsMember对象", description = "会员表")
public class UmsMember extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "UmsMember{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", nickname=" + nickname +
            ", headImg=" + headImg +
            ", registerMethod=" + registerMethod +
            ", phone=" + phone +
            ", email=" + email +
            ", status=" + status +
            ", createTime=" + createTime +
            ", loginTime=" + loginTime +
        "}";
    }
}
