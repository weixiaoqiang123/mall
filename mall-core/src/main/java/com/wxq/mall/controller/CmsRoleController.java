package com.wxq.mall.controller;

import com.wxq.mall.model.CmsMenu;
import com.wxq.mall.model.CmsMenuButtonDic;
import io.swagger.annotations.ApiOperation;
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
    private ICmsRoleService roleService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody CmsRole cmsRole) {
        roleService.add(cmsRole);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody CmsRole cmsRole) {
        roleService.update(cmsRole);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        roleService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        CmsRole entity = roleService.get(id);
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
        Page<CmsRole> pageModel = roleService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<CmsRole> data = roleService.findAll();
        return ResultBody.success(data);
    }
    
    @GetMapping("/findLeafMenusByRoleId/{roleId}")
    @ResponseBody
    @ApiOperation("查询角色授权叶子菜单列表")
    public ResultBody findMenusByRoleId(@PathVariable String roleId){
        List<CmsMenu> menus = roleService.findMenusByRoleId(roleId);
        return ResultBody.success(menus);
    }

    @GetMapping("/findRoleAuthButtons")
    @ResponseBody
    @ApiOperation("查询角色授权菜单授权按钮")
    public ResultBody findRoleAuthButtons(String roleId, String menuId) {
        List<CmsMenuButtonDic> buttonDicList = roleService.findRoleAuthButtons(roleId, menuId);
        return ResultBody.success(buttonDicList);
    }

    @PostMapping("/save-role-button-map/{roleId}")
    @ResponseBody
    @ApiOperation("保存角色与按钮关系")
    public ResultBody saveRoleButtonMap(@PathVariable String roleId, @RequestBody List<Integer> buttonDicIds) {
        roleService.saveRoleButtonMap(roleId, buttonDicIds);
        return ResultBody.success();
    }

}
