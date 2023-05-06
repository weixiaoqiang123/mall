package com.wxq.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author weixiaoqiang
 * @date 2023/4/22
 **/
@ApiModel("购买商品信息")
@Data
public class GoodsInfo {

    @ApiModelProperty("库存商品编码")
    private String skuCode;

    @ApiModelProperty("商品ID")
    private String productId;

    @ApiModelProperty("商家编码")
    private String businessCode;

    @ApiModelProperty("购买数量")
    private Integer shopNum;
}
