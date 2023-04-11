package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("pms_product")
@ApiModel(value = "PmsProduct对象", description = "商品表")
public class PmsProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商品编码,32位UUID")
    @TableField("product_id")
    private String productId;

    @ApiModelProperty("商家编码")
    @TableField("business_code")
    private String businessCode;

    @ApiModelProperty("商家名称")
    @TableField("business_name")
    private String businessName;

    @ApiModelProperty("商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("商品描述")
    @TableField("product_desc")
    private String productDesc;

    @ApiModelProperty("商品分类编码")
    @TableField("cate_code")
    private String cateCode;

    @ApiModelProperty("0 编辑 1 发布 2 下线")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("销售数量")
    @TableField("sale_num")
    private Integer saleNum;

    @ApiModelProperty("是否为新品: 0 否 1 是")
    @TableField("new_status")
    private Integer newStatus;

    @ApiModelProperty("是否推荐: 0 否 1 是")
    @TableField("recommand_status")
    private Integer recommandStatus;

    @ApiModelProperty("审核状态: 0 未审核 1 审核通过 2 审核不通过")
    @TableField("verify_status")
    private Integer verifyStatus;

    @TableField("price")
    private String price;

    @ApiModelProperty("商品库存")
    @TableField("stock")
    private Integer stock;

    @ApiModelProperty("预警库存")
    @TableField("low_stock")
    private Integer lowStock;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDate createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private LocalDate updateTime;

    @ApiModelProperty("发布时间")
    @TableField("publish_time")
    private LocalDate publishTime;

    @ApiModelProperty("下线时间")
    @TableField("off_time")
    private LocalDate offTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
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

    public LocalDate getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDate publishTime) {
        this.publishTime = publishTime;
    }

    public LocalDate getOffTime() {
        return offTime;
    }

    public void setOffTime(LocalDate offTime) {
        this.offTime = offTime;
    }


    @Override
    public String toString() {
        return "PmsProduct{" +
            "id=" + id +
            ", productId=" + productId +
            ", businessCode=" + businessCode +
            ", businessName=" + businessName +
            ", productName=" + productName +
            ", productDesc=" + productDesc +
            ", cateCode=" + cateCode +
            ", status=" + status +
            ", saleNum=" + saleNum +
            ", newStatus=" + newStatus +
            ", recommandStatus=" + recommandStatus +
            ", verifyStatus=" + verifyStatus +
            ", price=" + price +
            ", stock=" + stock +
            ", lowStock=" + lowStock +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", publishTime=" + publishTime +
            ", offTime=" + offTime +
        "}";
    }
}
