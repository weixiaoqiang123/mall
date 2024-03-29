package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("pms_product_attribute_value")
@ApiModel(value = "PmsProductAttributeValue对象", description = "商品属性值表")
public class PmsProductAttributeValue implements Serializable {

    private static final long serialVersionUID = 1L;

    public PmsProductAttributeValue(){}

    public PmsProductAttributeValue(String productId, String attributeId, String attrValueName) {
        this.productId = productId;
        this.attributeId = attributeId;
        this.attrValueName = attrValueName;
    }

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商品编码")
    @TableField("product_id")
    private String productId;

    @ApiModelProperty("属性ID")
    @TableField("attribute_id")
    private String attributeId;

    @ApiModelProperty("属性值")
    @TableField("attr_value_name")
    private String attrValueName;

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

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttrValueName() {
        return attrValueName;
    }

    public void setAttrValueName(String attrValueName) {
        this.attrValueName = attrValueName;
    }


    @Override
    public String toString() {
        return "PmsProductAttributeValue{" +
            "id=" + id +
            ", productId=" + productId +
            ", attributeId=" + attributeId +
            ", attrValueName=" + attrValueName +
        "}";
    }
}
