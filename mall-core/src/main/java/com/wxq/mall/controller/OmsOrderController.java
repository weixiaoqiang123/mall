package com.wxq.mall.controller;

import com.wxq.mall.dto.OrderPreInfo;
import com.wxq.mall.type.order.OrderStatus;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.OmsOrder;
import com.wxq.mall.service.IOmsOrderService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import org.springframework.stereotype.Controller;
import com.wxq.common.model.ResultBody;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/oms-order")
@ApiOperation("订单管理")
public class OmsOrderController {

    @Resource
    private IOmsOrderService orderService;

    @PostMapping("/create-order")
    public ResultBody<OmsOrder> createOrder(@RequestBody OrderPreInfo orderPreInfo) {
        OmsOrder order = orderService.createOrder(orderPreInfo);
        return ResultBody.success(order);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation("查询订单基本信息")
    public ResultBody<OmsOrder> get(@PathVariable String id) {
        OmsOrder entity = orderService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    @ApiOperation(value = "分页查询订单", notes = "用户或管理端查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页显示记录条数"),
            @ApiImplicitParam(name = "account", value = "用户账号"),
            @ApiImplicitParam(name = "username", value = "模糊查询用户姓名"),
            @ApiImplicitParam(name = "createTime", value = "订单创建时间"),
            @ApiImplicitParam(name = "status", value = "订单状态")
    })
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<OmsOrder> pageModel = orderService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }
}
