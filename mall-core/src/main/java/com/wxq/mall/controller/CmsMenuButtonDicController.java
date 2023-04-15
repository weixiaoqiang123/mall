package com.wxq.mall.controller;

import com.wxq.mall.type.ButtonAuthType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.CmsMenuButtonDic;
import com.wxq.mall.service.ICmsMenuButtonDicService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import com.wxq.common.model.ResultBody;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 *
 * 菜单按钮字典管理
 */
@Controller
@RequestMapping("/menu-button-dic")
@Api(tags = "菜单按钮字典管理")
public class CmsMenuButtonDicController {

    @Resource
    private ICmsMenuButtonDicService cmsMenuButtonDicService;

    @PostMapping
    @ResponseBody
    @ApiOperation("新增按钮字典")
    public ResultBody add(@RequestBody CmsMenuButtonDic cmsMenuButtonDic) {
        cmsMenuButtonDicService.add(cmsMenuButtonDic);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    @ApiOperation("修改按钮字典")
    public ResultBody update(@RequestBody CmsMenuButtonDic cmsMenuButtonDic) {
        cmsMenuButtonDicService.update(cmsMenuButtonDic);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation("删除按钮字典")
    public ResultBody delete(@PathVariable String id) {
        cmsMenuButtonDicService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/findByPage")
    @ResponseBody
    @ApiOperation("分页查询")
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<Map<String, String>> pageModel = cmsMenuButtonDicService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAllButtonAuthTypes")
    @ResponseBody
    @ApiOperation("查询所有按钮权限类型")
    public ResultBody findAllButtonAuthTypes(){
        return ResultBody.success(Arrays.asList(ButtonAuthType.values()));
    }

    @GetMapping("/checkCurrentMenuButtonIdUnique")
    @ResponseBody
    @ApiOperation("校验菜单按钮ID在当前菜单中是否唯一")
    public ResultBody checkCurrentMenuButtonIdUnique(@RequestParam String menuId, @RequestParam String buttonId){
        cmsMenuButtonDicService.checkCurrentMenuButtonIdUnique(menuId, buttonId);
        return ResultBody.success();
    }

    @GetMapping("/findMenuButtonsByMenuId")
    @ResponseBody
    @ApiOperation("根据菜单编码查询所有菜单按钮")
    public ResultBody findMenuButtonsByMenuId(String menuId) {
        List<CmsMenuButtonDic> buttonDicList = cmsMenuButtonDicService.findMenuButtonsByMenuId(menuId);
        return ResultBody.success(buttonDicList);
    }
}
