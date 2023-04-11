package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.UmsAdmin;
import com.wxq.mall.service.IUmsAdminService;
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
@RequestMapping("/ums-admin")
public class UmsAdminController {

    @Resource
    private IUmsAdminService umsAdminService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody UmsAdmin umsAdmin) {
        umsAdminService.add(umsAdmin);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody UmsAdmin umsAdmin) {
        umsAdminService.update(umsAdmin);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        umsAdminService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        UmsAdmin entity = umsAdminService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                 @RequestParam Integer page,
                                 @RequestParam Integer size) {
        Page<UmsAdmin> pageModel = umsAdminService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<UmsAdmin> data = umsAdminService.findAll();
        return ResultBody.success(data);
    }
}
