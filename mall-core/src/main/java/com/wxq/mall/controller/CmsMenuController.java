package com.wxq.mall.controller;

import com.wxq.core.TreeNode;
import com.wxq.mall.model.CmsRole;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.CmsMenu;
import com.wxq.mall.service.ICmsMenuService;
import java.util.List;
import org.springframework.stereotype.Controller;
import com.wxq.common.model.ResultBody;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/cms-menu")
public class CmsMenuController {

    @Resource
    private ICmsMenuService cmsMenuService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody CmsMenu cmsMenu) {
        cmsMenuService.add(cmsMenu);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody CmsMenu cmsMenu) {
        cmsMenuService.update(cmsMenu);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        cmsMenuService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        CmsMenu entity = cmsMenuService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findMenuTree")
    @ResponseBody
    public ResultBody findMenuTree() {
        List<TreeNode> menuTree = cmsMenuService.findMenuTree();
        return ResultBody.success(menuTree);
    }

    @PostMapping("/saveMenuRoles/{menuId}")
    @ResponseBody
    public ResultBody saveMenuRoles(@PathVariable String menuId, @RequestBody List<CmsRole> roles){
        cmsMenuService.saveMenuRoles(menuId, roles);
        return ResultBody.success();
    }

    @GetMapping("/findLastLevelMenus")
    @ResponseBody
    public ResultBody findLastLevelMenus(){
        List<CmsMenu> menus = cmsMenuService.findLastLevelMenus();
        return ResultBody.success(menus);
    }
}
