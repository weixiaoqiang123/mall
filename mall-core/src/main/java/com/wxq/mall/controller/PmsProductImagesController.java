package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductImages;
import com.wxq.mall.service.IPmsProductImagesService;
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
@RequestMapping("/pms-product-images")
public class PmsProductImagesController {

    @Resource
    private IPmsProductImagesService pmsProductImagesService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody PmsProductImages pmsProductImages) {
        pmsProductImagesService.add(pmsProductImages);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody PmsProductImages pmsProductImages) {
        pmsProductImagesService.update(pmsProductImages);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        pmsProductImagesService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        PmsProductImages entity = pmsProductImagesService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<PmsProductImages> pageModel = pmsProductImagesService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<PmsProductImages> data = pmsProductImagesService.findAll();
        return ResultBody.success(data);
    }
}
