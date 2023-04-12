package com.wxq.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsCart;
import com.wxq.mall.service.IPmsCartService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import org.springframework.stereotype.Controller;
import com.wxq.common.model.ResultBody;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/pms-cart")
@Api(tags = "购物车管理")
public class PmsCartController {

    @Resource
    private IPmsCartService cartService;

    @PostMapping
    @ResponseBody
    @ApiOperation("添加购物车")
    public ResultBody add(@RequestBody PmsCart pmsCart) {
        cartService.add(pmsCart);
        return ResultBody.success();
    }

    @GetMapping("update-count/{id}")
    @ResponseBody
    @ApiOperation("修改购物车商品数量")
    public ResultBody updateCartCount(@PathVariable Integer id, @RequestParam Integer count) {
        cartService.updateCartCount(id, count);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        cartService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        PmsCart entity = cartService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<Map<String, Object>> pageModel = cartService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }
}
