package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
public abstract class User {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    protected Integer id;

    @ApiModelProperty("用户名")
    protected String username;

    @ApiModelProperty("密码")
    protected String password;

    @ApiModelProperty("用户昵称")
    protected String nickname;

    @ApiModelProperty("用户头像")
    protected String headImg;

    /**
     * @see com.wxq.mall.type.UserRegisterMethod
     */
    @ApiModelProperty("注册方式: mobile/qq")
    protected String registerMethod;

    @ApiModelProperty("手机号")
    protected String phone;

    @ApiModelProperty("邮箱")
    protected String email;

    @ApiModelProperty("创建时间")
    protected Date createTime;

    /**
     * @see com.wxq.mall.type.UserStatus
     */
    @ApiModelProperty("用户状态: 0 未启用 1 启用")
    protected Integer status;

    @ApiModelProperty("最后登录时间")
    protected Date loginTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
