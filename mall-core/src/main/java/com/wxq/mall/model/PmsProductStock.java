package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("pms_product_stock")
@ApiModel(value = "PmsProductStock对象", description = "商品库存表")
public class PmsProductStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableField("id")
    private Integer id;

    @ApiModelProperty("库存图片")
    @TableField("image")
    private String image;

    @ApiModelProperty("商品ID")
    @TableField("product_id")
    private String productId;

    @ApiModelProperty("商品库存编码")
    @TableField("sku_code")
    private String skuCode;

    @ApiModelProperty("原价")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("促销价格")
    @TableField("promotion_price")
    private BigDecimal promotionPrice;

    @ApiModelProperty("销售数量")
    @TableField("sale_num")
    private Integer saleNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }


    @Override
    public String toString() {
        return "PmsProductStock{" +
            "id=" + id +
            ", image=" + image +
            ", productId=" + productId +
            ", skuCode=" + skuCode +
            ", price=" + price +
            ", promotionPrice=" + promotionPrice +
            ", saleNum=" + saleNum +
        "}";
    }
}
