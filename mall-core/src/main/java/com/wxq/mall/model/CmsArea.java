package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("cms_area")
@ApiModel(value = "CmsArea对象", description = "地区表")
public class CmsArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("地区编码")
    private String areaCode;

    @ApiModelProperty("地区名称")
    private String areaName;

    @ApiModelProperty("父级地区编码")
    private String parentAreaCode;

    @ApiModelProperty("地区级别")
    private String areaLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getParentAreaCode() {
        return parentAreaCode;
    }

    public void setParentAreaCode(String parentAreaCode) {
        this.parentAreaCode = parentAreaCode;
    }

    public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel;
    }


    @Override
    public String toString() {
        return "CmsArea{" +
            "id=" + id +
            ", areaCode=" + areaCode +
            ", areaName=" + areaName +
            ", parentAreaCode=" + parentAreaCode +
            ", areaLevel=" + areaLevel +
        "}";
    }
}
