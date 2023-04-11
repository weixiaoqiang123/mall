package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("ums_admin")
@ApiModel(value = "UmsAdmin对象", description = "管理员用户表")
public class UmsAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("用户头像")
    private String headImg;

    @ApiModelProperty("注册方式: mobile/qq")
    private String registerMethod;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("创建时间")
    private LocalDate createTime;

    @ApiModelProperty("用户状态: 0 未启用 1 启用")
    private Integer status;

    @ApiModelProperty("最后登录时间")
    private LocalDate loginTime;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getRegisterMethod() {
        return registerMethod;
    }

    public void setRegisterMethod(String registerMethod) {
        this.registerMethod = registerMethod;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDate getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
    }


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
