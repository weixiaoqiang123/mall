package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.UmsBusiness;
import com.wxq.mall.service.IUmsBusinessService;
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
@RequestMapping("/ums-business")
public class UmsBusinessController {

    @Resource
    private IUmsBusinessService umsBusinessService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody UmsBusiness umsBusiness) {
        umsBusinessService.add(umsBusiness);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody UmsBusiness umsBusiness) {
        umsBusinessService.update(umsBusiness);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        umsBusinessService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        UmsBusiness entity = umsBusinessService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<UmsBusiness> pageModel = umsBusinessService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<UmsBusiness> data = umsBusinessService.findAll();
        return ResultBody.success(data);
    }
}
