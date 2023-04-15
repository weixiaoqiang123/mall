package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wxq.mall.type.product.ProductStatus;
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
    @TableField(value = "id")
    private Integer id;

    @ApiModelProperty("商品编码,32位UUID")
    @TableId("product_id")
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

    /**
     * @see ProductStatus
     */
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
    @TableField("recommend_status")
    private Integer recommendStatus;

    /**
     * @see com.wxq.mall.type.product.ProductApproveStatus
     */
    @ApiModelProperty("审核状态: 0 审核中 1 审核通过 2 审核不通过")
    @TableField("verify_status")
    private Integer verifyStatus;

    @TableField("sale_price")
    @ApiModelProperty("上架")
    private String salePrice;

    @ApiModelProperty("商品库存")
    @TableField("stock")
    private Integer stock;

    @ApiModelProperty("预警库存")
    @TableField("low_stock")
    private Integer lowStock;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("发布时间")
    @TableField("publish_time")
    private Date publishTime;

    @ApiModelProperty("下线时间")
    @TableField("off_time")
    private Date offlineTime;

    @ApiModelProperty("商品图片列表")
    @TableField(exist = false)
    private List<PmsProductImages> images = new ArrayList<>();

    @ApiModelProperty(value = "商品属性列表", notes = "关联查询属性值")
    @TableField(exist = false)
    private List<PmsProductAttribute> attrs = new ArrayList<>();

    @ApiModelProperty("商品详情信息")
    @TableField(exist = false)
    private PmsProductDetail detail;


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

    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(Date offlineTime) {
        this.offlineTime = offlineTime;
    }

    public List<PmsProductImages> getImages() {
        return images;
    }

    public void setImages(List<PmsProductImages> images) {
        this.images = images;
    }

    public List<PmsProductAttribute> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<PmsProductAttribute> attrs) {
        this.attrs = attrs;
    }

    public PmsProductDetail getDetail() {
        return detail;
    }

    public void setDetail(PmsProductDetail detail) {
        this.detail = detail;
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
            ", recommendStatus=" + recommendStatus +
            ", verifyStatus=" + verifyStatus +
            ", salePrice=" + salePrice +
            ", stock=" + stock +
            ", lowStock=" + lowStock +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", publishTime=" + publishTime +
            ", offlineTime=" + offlineTime +
        "}";
    }
}
