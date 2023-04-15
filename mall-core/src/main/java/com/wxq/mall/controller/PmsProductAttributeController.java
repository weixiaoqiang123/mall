package com.wxq.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductAttribute;
import com.wxq.mall.service.IPmsProductAttributeService;
import java.util.List;
import org.springframework.stereotype.Controller;
import com.wxq.common.model.ResultBody;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/product-attribute")
@Api(tags = "商品属性管理")
public class PmsProductAttributeController {

    @Resource
    private IPmsProductAttributeService productAttributeService;

    @PostMapping("/{productId}")
    @ResponseBody
    @ApiOperation("保存商品属性")
    public ResultBody save(@PathVariable String productId, @RequestBody List<PmsProductAttribute> pmsProductAttributes) {
        productAttributeService.save(productId, pmsProductAttributes);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation("根据ID删除商品属性")
    public ResultBody delete(@PathVariable String id) {
        productAttributeService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/findAttrsByProductId/{productId}")
    @ResponseBody
    @ApiOperation("根据商品编码查询商品属性列表")
    public ResultBody findAttrsByProductId(@PathVariable String productId) {
        List<PmsProductAttribute> data = productAttributeService.findAttrsByProductId(productId);
        return ResultBody.success(data);
    }
}
