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
@TableName("oms_order_detail")
@ApiModel(value = "OmsOrderDetail对象", description = "订单详情表")
public class OmsOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("订单编码")
    @TableField("oder_code")
    private String oderCode;

    @ApiModelProperty("商品编码")
    @TableField("product_id")
    private String productId;

    @ApiModelProperty("商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("商品库存编码")
    @TableField("sku_code")
    private String skuCode;

    @ApiModelProperty("购买数量")
    @TableField("buy_num")
    private Integer buyNum;

    @ApiModelProperty("商品属性")
    @TableField("product_attr")
    private String productAttr;

    @ApiModelProperty("订单创建时间")
    @TableField("create_time")
    private LocalDate createTime;

    @ApiModelProperty("原价")
    @TableField("original_price")
    private BigDecimal originalPrice;

    @ApiModelProperty("售价")
    @TableField("sale_price")
    private BigDecimal salePrice;

    @ApiModelProperty("商家编码")
    @TableField("business_code")
    private String businessCode;

    @ApiModelProperty("商家名称")
    @TableField("business_name")
    private String businessName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOderCode() {
        return oderCode;
    }

    public void setOderCode(String oderCode) {
        this.oderCode = oderCode;
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

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
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


    @Override
    public String toString() {
        return "OmsOrderDetail{" +
            "id=" + id +
            ", oderCode=" + oderCode +
            ", productId=" + productId +
            ", productName=" + productName +
            ", skuCode=" + skuCode +
            ", buyNum=" + buyNum +
            ", productAttr=" + productAttr +
            ", createTime=" + createTime +
            ", originalPrice=" + originalPrice +
            ", salePrice=" + salePrice +
            ", businessCode=" + businessCode +
            ", businessName=" + businessName +
        "}";
    }
}
