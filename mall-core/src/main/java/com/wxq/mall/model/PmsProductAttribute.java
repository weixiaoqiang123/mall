package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("pms_product_attribute")
@ApiModel(value = "PmsProductAttribute对象", description = "商品属性表")
public class PmsProductAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商品编码")
    @TableField("product_id")
    private String productId;

    @ApiModelProperty("属性ID")
    @TableField("attr_id")
    private String attrId;

    @ApiModelProperty("属性名称")
    @TableField("attr_name")
    private String attrName;

    @ApiModelProperty("商品属性值集合")
    @TableField(exist = false)
    private List<PmsProductAttributeValue> attrValues = new ArrayList<>();

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

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public void setAttrValues(List<PmsProductAttributeValue> attrValues) {
        this.attrValues = attrValues;
    }

    public List<PmsProductAttributeValue> getAttrValues() {
        return attrValues;
    }

    @Override
    public String toString() {
        return "PmsProductAttribute{" +
            "id=" + id +
            ", productId=" + productId +
            ", attrId=" + attrId +
            ", attrName=" + attrName +
        "}";
    }
}
