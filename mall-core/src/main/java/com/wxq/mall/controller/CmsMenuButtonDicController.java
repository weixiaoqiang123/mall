package com.wxq.mall.controller;

import com.wxq.mall.type.ButtonAuthType;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.CmsMenuButtonDic;
import com.wxq.mall.service.ICmsMenuButtonDicService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Arrays;
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
public class CmsMenuButtonDicController {

    @Resource
    private ICmsMenuButtonDicService cmsMenuButtonDicService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody CmsMenuButtonDic cmsMenuButtonDic) {
        cmsMenuButtonDicService.add(cmsMenuButtonDic);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody CmsMenuButtonDic cmsMenuButtonDic) {
        cmsMenuButtonDicService.update(cmsMenuButtonDic);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        cmsMenuButtonDicService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        CmsMenuButtonDic entity = cmsMenuButtonDicService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<Map<String, String>> pageModel = cmsMenuButtonDicService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAllButtonAuthTypes")
    @ResponseBody
    public ResultBody findAllButtonAuthTypes(){
        return ResultBody.success(Arrays.asList(ButtonAuthType.values()));
    }

    @GetMapping("/checkCurrentMenuButtonIdUnique")
    @ResponseBody
    public ResultBody checkCurrentMenuButtonIdUnique(@RequestParam String menuId, @RequestParam String buttonId){
        cmsMenuButtonDicService.checkCurrentMenuButtonIdUnique(menuId, buttonId);
        return ResultBody.success();
    }
}
