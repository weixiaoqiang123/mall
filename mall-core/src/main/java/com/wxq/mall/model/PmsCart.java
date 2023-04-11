package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("pms_cart")
@ApiModel(value = "PmsCart对象", description = "购物车")
public class PmsCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户账号")
    private String account;

    @ApiModelProperty("商品ID")
    private String productId;

    @ApiModelProperty("商品名称")
    private String productName;

    @ApiModelProperty("商品库存编码")
    private String skuCode;

    @ApiModelProperty("商品属性(json)")
    private String productAttr;

    @ApiModelProperty("商品原价")
    private BigDecimal price;

    @ApiModelProperty("商品数量")
    private Integer quantity;

    @ApiModelProperty("商品主图")
    private String picture;

    @ApiModelProperty("商家编码")
    private String businessCode;

    @ApiModelProperty("商家名称")
    private String businessName;

    @ApiModelProperty("创建时间")
    private LocalDate createTime;

    @ApiModelProperty("修改时间")
    private LocalDate updateTime;

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

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return "PmsCart{" +
            "id=" + id +
            ", account=" + account +
            ", productId=" + productId +
            ", productName=" + productName +
            ", skuCode=" + skuCode +
            ", productAttr=" + productAttr +
            ", price=" + price +
            ", quantity=" + quantity +
            ", picture=" + picture +
            ", businessCode=" + businessCode +
            ", businessName=" + businessName +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
