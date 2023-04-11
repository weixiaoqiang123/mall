package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductDetail;
import com.wxq.mall.service.IPmsProductDetailService;
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
@RequestMapping("/pms-product-detail")
public class PmsProductDetailController {

    @Resource
    private IPmsProductDetailService pmsProductDetailService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody PmsProductDetail pmsProductDetail) {
        pmsProductDetailService.add(pmsProductDetail);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody PmsProductDetail pmsProductDetail) {
        pmsProductDetailService.update(pmsProductDetail);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        pmsProductDetailService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        PmsProductDetail entity = pmsProductDetailService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<PmsProductDetail> pageModel = pmsProductDetailService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<PmsProductDetail> data = pmsProductDetailService.findAll();
        return ResultBody.success(data);
    }
}
