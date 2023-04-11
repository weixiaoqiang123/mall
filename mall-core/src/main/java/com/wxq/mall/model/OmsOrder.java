package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户账号")
    @TableField("account")
    private String account;

    @ApiModelProperty("订单编码")
    @TableField("order_code")
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
    @TableField("souce_type")
    private Integer souceType;

    @ApiModelProperty("订单状态: 0 未付款 1 待发货 2 已发货 3 已收货")
    @TableField("stauts")
    private Integer stauts;

    @ApiModelProperty("订单类型: 0 正常订单 1 秒杀订单")
    @TableField("order_type")
    private Integer orderType;

    @ApiModelProperty("收货状态: 0 未确认 1 已确认")
    @TableField("confirm_status")
    private Integer confirmStatus;

    @ApiModelProperty("订单创建时间")
    @TableField("create_time")
    private LocalDate createTime;

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

    public Integer getSouceType() {
        return souceType;
    }

    public void setSouceType(Integer souceType) {
        this.souceType = souceType;
    }

    public Integer getStauts() {
        return stauts;
    }

    public void setStauts(Integer stauts) {
        this.stauts = stauts;
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

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
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
            ", souceType=" + souceType +
            ", stauts=" + stauts +
            ", orderType=" + orderType +
            ", confirmStatus=" + confirmStatus +
            ", createTime=" + createTime +
        "}";
    }
}
