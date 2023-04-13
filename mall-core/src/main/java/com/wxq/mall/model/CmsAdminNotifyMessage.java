package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author weixiaoqiang
 * @date 2023-04-13
 */
@TableName("cms_admin_notify_message")
@ApiModel(value = "CmsAdminNotifyMessage对象", description = "用户消息通知表")
public class CmsAdminNotifyMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键名称")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("消息内容")
    @TableField("message")
    private String message;

    @ApiModelProperty("0 未读 1 已读")
    @TableField("is_read")
    private Integer read;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer isRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }


    @Override
    public String toString() {
        return "CmsAdminNotifyMessage{" +
            "id=" + id +
            ", username=" + username +
            ", message=" + message +
            ", read=" + read +
        "}";
    }
}
