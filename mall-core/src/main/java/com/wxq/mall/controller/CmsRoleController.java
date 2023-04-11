package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.CmsRole;
import com.wxq.mall.service.ICmsRoleService;
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
@RequestMapping("/cms-role")
public class CmsRoleController {

    @Resource
    private ICmsRoleService cmsRoleService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody CmsRole cmsRole) {
        cmsRoleService.add(cmsRole);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody CmsRole cmsRole) {
        cmsRoleService.update(cmsRole);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        cmsRoleService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        CmsRole entity = cmsRoleService.get(id);
        return ResultBody.success(entity);
    }

    /**
     * 分页查询角色名称
     * roleName 模糊查询角色名称
     * roleId  精确匹配角色ID
     * @param params
     * @param page 当前页
     * @param size 每页显示记录条数
     * @return 角色列表
     */
    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<CmsRole> pageModel = cmsRoleService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<CmsRole> data = cmsRoleService.findAll();
        return ResultBody.success(data);
    }
}
