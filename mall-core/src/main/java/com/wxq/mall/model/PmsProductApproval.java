package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("pms_product_approval")
@ApiModel(value = "PmsProductApproval对象", description = "商品上架审核表")
public class PmsProductApproval implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("商家名称")
    @TableField("business_name")
    private String businessName;

    @ApiModelProperty("商品ID")
    @TableField("product_id")
    private String productId;

    @ApiModelProperty("商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("审核状态: 0 审核中 1 审核通过 2 审核不通过")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("审核不通过原因")
    @TableField("not_pass_message")
    private String notPassMessage;

    @ApiModelProperty("审核记录创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("审核时间")
    @TableField("verify_time")
    private Date verifyTime;

    @ApiModelProperty("审核人名称")
    @TableField("verify_name")
    private String verifyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNotPassMessage() {
        return notPassMessage;
    }

    public void setNotPassMessage(String notPassMessage) {
        this.notPassMessage = notPassMessage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getVerifyName() {
        return verifyName;
    }

    public void setVerifyName(String verifyName) {
        this.verifyName = verifyName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "PmsProductApproval{" +
            "id=" + id +
            ", username=" + username +
            ", businessName=" + businessName +
            ", productId=" + productId +
            ", productName=" + productName +
            ", status=" + status +
            ", notPassMessage=" + notPassMessage +
            ", createTime=" + createTime +
            ", verifyTime=" + verifyTime +
            ", verifyName=" + verifyName +
        "}";
    }
}
