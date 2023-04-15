package com.wxq.mall.controller;

import com.wxq.mall.model.CmsMenu;
import com.wxq.mall.model.CmsMenuButtonDic;
import io.swagger.annotations.*;
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
@Api(tags = "角色管理")
public class CmsRoleController {

    @Resource
    private ICmsRoleService roleService;

    @PostMapping
    @ResponseBody
    @ApiOperation("新增角色")
    public ResultBody add(@RequestBody CmsRole cmsRole) {
        roleService.add(cmsRole);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    @ApiOperation("修改角色")
    public ResultBody update(@RequestBody CmsRole cmsRole) {
        roleService.update(cmsRole);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据ID删除角色", notes = "id为主键字段")
    public ResultBody delete(@PathVariable String id) {
        roleService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "查询角色信息", notes = "id为主键字段")
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
    @ApiOperation(value = "分页查询角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "精确匹配角色ID"),
            @ApiImplicitParam(name = "roleName", value = "模糊匹配角色名称")
    })
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<CmsRole> pageModel = roleService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    @ApiOperation("查询全部角色")
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
