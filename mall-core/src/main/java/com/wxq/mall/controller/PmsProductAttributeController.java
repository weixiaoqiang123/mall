package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductAttribute;
import com.wxq.mall.service.IPmsProductAttributeService;
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
@RequestMapping("/pms-product-attribute")
public class PmsProductAttributeController {

    @Resource
    private IPmsProductAttributeService pmsProductAttributeService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody PmsProductAttribute pmsProductAttribute) {
        pmsProductAttributeService.add(pmsProductAttribute);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody PmsProductAttribute pmsProductAttribute) {
        pmsProductAttributeService.update(pmsProductAttribute);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        pmsProductAttributeService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        PmsProductAttribute entity = pmsProductAttributeService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<PmsProductAttribute> pageModel = pmsProductAttributeService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<PmsProductAttribute> data = pmsProductAttributeService.findAll();
        return ResultBody.success(data);
    }
}
