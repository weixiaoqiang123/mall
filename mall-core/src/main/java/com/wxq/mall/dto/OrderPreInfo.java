package com.wxq.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023/4/22
 *
 * 订单预处理信息
 **/
@ApiModel("订单预处理信息")
@Data
public class OrderPreInfo {

    @ApiModelProperty("购买人账号")
    private String account;

    @ApiModelProperty("订单总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty("购买商品信息")
    private List<GoodsInfo> goodsInfos = new ArrayList<>();

    @ApiModelProperty("收货地址")
    private ReceiveAddress receiveAddress;
}
