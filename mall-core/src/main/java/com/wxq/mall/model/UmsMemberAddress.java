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
@TableName("ums_member_address")
@ApiModel(value = "UmsMemberAddress对象", description = "会员收获地址表")
public class UmsMemberAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("会员关联ID")
    @TableField("member_id")
    private String memberId;

    @ApiModelProperty("收件人姓名")
    @TableField("receive_name")
    private String receiveName;

    @ApiModelProperty("收件人电话")
    @TableField("receive_phone")
    private String receivePhone;

    @ApiModelProperty("省编码")
    @TableField("province_id")
    private String provinceId;

    @ApiModelProperty("市")
    @TableField("city_id")
    private String cityId;

    @ApiModelProperty("区/县")
    @TableField("region_id")
    private String regionId;

    @ApiModelProperty("详细地址")
    @TableField("detail_address")
    private String detailAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
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


    @Override
    public String toString() {
        return "UmsMemberAddress{" +
            "id=" + id +
            ", memberId=" + memberId +
            ", receiveName=" + receiveName +
            ", receivePhone=" + receivePhone +
            ", provinceId=" + provinceId +
            ", cityId=" + cityId +
            ", regionId=" + regionId +
            ", detailAddress=" + detailAddress +
        "}";
    }
}
