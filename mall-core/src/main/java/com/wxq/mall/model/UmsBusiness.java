package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("ums_business")
@ApiModel(value = "UmsBusiness对象", description = "商家表")
public class UmsBusiness implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableField("id")
    private Integer id;

    @ApiModelProperty("商家编码")
    @TableId("business_code")
    private String businessCode;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("商家名称")
    @TableField("business_name")
    private String businessName;

    @ApiModelProperty("省")
    @TableField("province_id")
    private String provinceId;

    @ApiModelProperty("市")
    @TableField("city_id")
    private String cityId;

    @ApiModelProperty("区/县")
    @TableField("region_id")
    private String regionId;

    @ApiModelProperty("商家详细地址(街道)")
    @TableField("detail_address")
    private String detailAddress;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    @Override
    public String toString() {
        return "UmsBusiness{" +
            "id=" + id +
            ", username=" + username +
            ", businessName=" + businessName +
            ", provinceId=" + provinceId +
            ", cityId=" + cityId +
            ", regionId=" + regionId +
            ", detailAddress=" + detailAddress +
            ", createTime=" + createTime +
        "}";
    }
}
