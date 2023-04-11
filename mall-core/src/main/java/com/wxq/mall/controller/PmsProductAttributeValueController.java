package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductAttributeValue;
import com.wxq.mall.service.IPmsProductAttributeValueService;
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
@RequestMapping("/pms-product-attribute-value")
public class PmsProductAttributeValueController {

    @Resource
    private IPmsProductAttributeValueService pmsProductAttributeValueService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody PmsProductAttributeValue pmsProductAttributeValue) {
        pmsProductAttributeValueService.add(pmsProductAttributeValue);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody PmsProductAttributeValue pmsProductAttributeValue) {
        pmsProductAttributeValueService.update(pmsProductAttributeValue);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        pmsProductAttributeValueService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        PmsProductAttributeValue entity = pmsProductAttributeValueService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<PmsProductAttributeValue> pageModel = pmsProductAttributeValueService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<PmsProductAttributeValue> data = pmsProductAttributeValueService.findAll();
        return ResultBody.success(data);
    }
}
