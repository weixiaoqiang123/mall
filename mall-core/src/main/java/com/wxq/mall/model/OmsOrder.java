package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("oms_order")
@ApiModel(value = "OmsOrder对象", description = "订单表")
public class OmsOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableField("id")
    private Integer id;

    @ApiModelProperty("用户账号")
    @TableField("account")
    private String account;

    @ApiModelProperty("订单编码")
    @TableId("order_code")
    private String orderCode;

    @ApiModelProperty("订单总金额")
    @TableField("total_amount")
    private BigDecimal totalAmount;

    @ApiModelProperty("实际支付金额")
    @TableField("pay_amount")
    private BigDecimal payAmount;

    @ApiModelProperty("支付类型: 0 未支付 1 支付宝 2 微信")
    @TableField("pay_type")
    private Integer payType;

    @ApiModelProperty("订单来源: 1 pc 2手机")
    @TableField("source_type")
    private Integer sourceType;

    @ApiModelProperty("订单状态: 0 未付款 1 待发货 2 已发货 3 已收货")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("订单类型: 0 正常订单 1 秒杀订单")
    @TableField("order_type")
    private Integer orderType;

    @ApiModelProperty("收货状态: 0 未确认 1 已确认")
    @TableField("confirm_status")
    private Integer confirmStatus;

    @ApiModelProperty("订单创建时间")
    @TableField("create_time")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "OmsOrder{" +
            "id=" + id +
            ", account=" + account +
            ", orderCode=" + orderCode +
            ", totalAmount=" + totalAmount +
            ", payAmount=" + payAmount +
            ", payType=" + payType +
            ", sourceType=" + sourceType +
            ", status=" + status +
            ", orderType=" + orderType +
            ", confirmStatus=" + confirmStatus +
            ", createTime=" + createTime +
        "}";
    }
}
