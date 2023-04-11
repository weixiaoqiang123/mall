package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
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
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("商家名称")
    private String businessName;

    @ApiModelProperty("省")
    private String provinceId;

    @ApiModelProperty("市")
    private String cityId;

    @ApiModelProperty("区/县")
    private String regionId;

    @ApiModelProperty("商家详细地址(街道)")
    private String detailAddress;

    @ApiModelProperty("创建时间")
    private LocalDate createTime;

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

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
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
