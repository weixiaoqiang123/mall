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
@TableName("pms_banner")
@ApiModel(value = "PmsBanner对象", description = "首页轮播图表")
public class PmsBanner implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("图片名称")
    private String name;

    @ApiModelProperty("图片地址")
    private String url;

    @ApiModelProperty("图片状态: 0 不生效 1 生效")
    private Integer status;

    @ApiModelProperty("图片顺序")
    private Integer order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }


    @Override
    public String toString() {
        return "PmsBanner{" +
            "id=" + id +
            ", name=" + name +
            ", url=" + url +
            ", status=" + status +
            ", order=" + order +
        "}";
    }
}
