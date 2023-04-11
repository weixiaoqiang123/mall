package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsBanner;
import com.wxq.mall.service.IPmsBannerService;
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
@RequestMapping("/pms-banner")
public class PmsBannerController {

    @Resource
    private IPmsBannerService pmsBannerService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody PmsBanner pmsBanner) {
        pmsBannerService.add(pmsBanner);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody PmsBanner pmsBanner) {
        pmsBannerService.update(pmsBanner);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        pmsBannerService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        PmsBanner entity = pmsBannerService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<PmsBanner> pageModel = pmsBannerService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<PmsBanner> data = pmsBannerService.findAll();
        return ResultBody.success(data);
    }
}
