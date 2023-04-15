package com.wxq.mall.controller;

import com.wxq.mall.model.PmsProductAttribute;
import com.wxq.mall.model.PmsProductDetail;
import com.wxq.mall.service.IPmsProductAttributeService;
import com.wxq.mall.service.IPmsProductDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @Resource
    private IPmsProductAttributeService productAttributeService;

    @Resource
    private IPmsProductDetailService pmsProductDetailService;

    @PostMapping
    @ResponseBody
    @ApiOperation("保存商品基本信息")
    public ResultBody save(@RequestBody PmsProduct pmsProduct) {
        productService.save(pmsProduct);
        return ResultBody.success();
    }

    @DeleteMapping("/{productId}")
    @ResponseBody
    @ApiOperation(value = "删除商品")
    @ApiImplicitParam(name = "productId", value = "商品编码")
    public ResultBody delete(@PathVariable String productId) {
        productService.delete(productId);
        return ResultBody.success();
    }

    @GetMapping("/getRoot/{productId}")
    @ResponseBody
    @ApiOperation("查询商品详情")
    public ResultBody<PmsProduct> getRoot(@PathVariable String productId) {
        PmsProduct entity = productService.getRoot(productId);
        return ResultBody.success(entity);
    }

    @GetMapping("/info/{productId}")
    @ResponseBody
    @ApiOperation("查询商品基本信息")
    public ResultBody get(@PathVariable String productId) {
        PmsProduct entity = productService.get(productId);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    @ApiOperation("分页查询商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页显示记录条数"),
            @ApiImplicitParam(name = "productName", value = "模糊查询商品名称")
    })
    public ResultBody findByPage(@RequestParam(required = false) Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<PmsProduct> pageModel = productService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/publish/{productId}")
    @ResponseBody
    @ApiOperation("上架商品")
    public ResultBody publish(@PathVariable String productId) {
        productService.publish(productId);
        return ResultBody.success();
    }

    @GetMapping("/offLine/{productId}")
    @ResponseBody
    @ApiOperation("下架商品")
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

    @PostMapping("/attr/{productId}")
    @ResponseBody
    @ApiOperation("保存商品属性和属性值")
    public ResultBody save(@PathVariable String productId, @RequestBody List<PmsProductAttribute> attrs) {
        productAttributeService.save(productId, attrs);
        return ResultBody.success();
    }

    @GetMapping("/attr/findAttrsByProductId/{productId}")
    @ResponseBody
    @ApiOperation(value = "根据商品编码查询商品属性列表", notes = "关联查询属性对应属性值")
    @Deprecated
    public ResultBody findAttrsByProductId(@PathVariable String productId) {
        List<PmsProductAttribute> data = productAttributeService.findAttrsByProductId(productId);
        return ResultBody.success(data);
    }

    @PostMapping("/detail/{productId}")
    @ResponseBody
    @ApiOperation("保存商品详情")
    public ResultBody saveProductDetail(@PathVariable String productId, @RequestBody PmsProductDetail detail) {
        pmsProductDetailService.save(productId, detail);
        return ResultBody.success();
    }
}
