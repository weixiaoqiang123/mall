package com.wxq.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsProduct;
import com.wxq.mall.service.IPmsProductService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;
import org.springframework.stereotype.Controller;
import com.wxq.common.model.ResultBody;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/product")
@Api(tags = "商品管理")
public class PmsProductController {

    @Resource
    private IPmsProductService productService;

    @PostMapping
    @ResponseBody
    public ResultBody save(@RequestBody PmsProduct pmsProduct) {
        productService.save(pmsProduct);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        productService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        PmsProduct entity = productService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<PmsProduct> pageModel = productService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<PmsProduct> data = productService.findAll();
        return ResultBody.success(data);
    }

    @GetMapping("/publish/{productId}")
    @ResponseBody
    public ResultBody publish(@PathVariable String productId) {
        productService.publish(productId);
        return ResultBody.success();
    }

    @GetMapping("/offLine/{productId}")
    @ResponseBody
    public ResultBody offLine(@PathVariable String productId){
        productService.offLine(productId);
        return ResultBody.success();
    }

    @GetMapping("/updateRecommendStatus/{productId}")
    @ResponseBody
    @ApiOperation("修改推荐状态")
    public ResultBody updateRecommendStatus(@PathVariable String productId, @RequestParam Integer status){
        productService.updateRecommendStatus(productId, status);
        return ResultBody.success();
    }

    @GetMapping("/updateNewProductStatus/{productId}")
    @ResponseBody
    @ApiOperation("修改新品状态")
    public ResultBody updateNewProductStatus(@PathVariable String productId, @RequestParam Integer status){
        productService.updateNewProductStatus(productId, status);
        return ResultBody.success();
    }
}
