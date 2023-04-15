package com.wxq.mall.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsBanner;
import com.wxq.mall.service.IPmsBannerService;
import java.util.List;
import org.springframework.stereotype.Controller;
import com.wxq.common.model.ResultBody;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/pms-banner")
@ApiOperation("轮播图管理")
public class PmsBannerController {

    @Resource
    private IPmsBannerService pmsBannerService;

    @PostMapping
    @ResponseBody
    @ApiOperation("新增轮播图图片")
    public ResultBody add(@RequestBody PmsBanner pmsBanner) {
        pmsBannerService.add(pmsBanner);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    @ApiOperation("修改轮播图图片")
    public ResultBody update(@RequestBody PmsBanner pmsBanner) {
        pmsBannerService.update(pmsBanner);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation("删除轮播图图片")
    public ResultBody delete(@PathVariable String id) {
        pmsBannerService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation("根据ID查询轮播图图片")
    public ResultBody get(@PathVariable String id) {
        PmsBanner entity = pmsBannerService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findAll")
    @ResponseBody
    @ApiOperation("查询轮播图列表")
    public ResultBody findAll() {
        List<PmsBanner> data = pmsBannerService.findAll();
        return ResultBody.success(data);
    }
}
