package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.UmsAdminLoginLog;
import com.wxq.mall.service.IUmsAdminLoginLogService;
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
@RequestMapping("/ums-admin-login-log")
public class UmsAdminLoginLogController {

    @Resource
    private IUmsAdminLoginLogService umsAdminLoginLogService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody UmsAdminLoginLog umsAdminLoginLog) {
        umsAdminLoginLogService.add(umsAdminLoginLog);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody UmsAdminLoginLog umsAdminLoginLog) {
        umsAdminLoginLogService.update(umsAdminLoginLog);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        umsAdminLoginLogService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        UmsAdminLoginLog entity = umsAdminLoginLogService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<UmsAdminLoginLog> pageModel = umsAdminLoginLogService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<UmsAdminLoginLog> data = umsAdminLoginLogService.findAll();
        return ResultBody.success(data);
    }
}
