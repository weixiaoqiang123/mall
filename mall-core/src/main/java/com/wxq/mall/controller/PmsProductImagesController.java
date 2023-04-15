package com.wxq.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductImages;
import com.wxq.mall.service.IPmsProductImagesService;
import java.util.List;
import org.springframework.stereotype.Controller;
import com.wxq.common.model.ResultBody;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/product-images")
@Api(tags = "商品图片管理")
public class PmsProductImagesController {

    @Resource
    private IPmsProductImagesService pmsProductImagesService;

    @PostMapping
    @ResponseBody
    @ApiOperation("新增图片")
    public ResultBody add(@RequestBody PmsProductImages pmsProductImages) {
        pmsProductImagesService.add(pmsProductImages);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation("删除图片")
    public ResultBody delete(@PathVariable String id) {
        pmsProductImagesService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/pictures/{productId}")
    @ResponseBody
    @ApiOperation("根据商品编码查询图片列表")
    public ResultBody findPictureByProductId(@PathVariable String productId) {
        List<PmsProductImages> data = pmsProductImagesService.findPictureByProductId(productId);
        return ResultBody.success(data);
    }
}
