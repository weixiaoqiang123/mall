package com.wxq.mall.controller;

import com.wxq.modeltree.core.TreeNode;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.service.ICmsAreaService;
import org.springframework.stereotype.Controller;
import com.wxq.common.model.ResultBody;

import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/area")
@Api(tags = "地区管理")
public class CmsAreaController {

    @Resource
    private ICmsAreaService areaService;

    @GetMapping("/provinces")
    @ResponseBody
    public ResultBody provinces(){
        List<TreeNode> provinces = areaService.provinces();
        return ResultBody.success(provinces);
    }

    @GetMapping("/children/{parentCode}")
    @ResponseBody
    public ResultBody findAreaTree(@PathVariable String parentCode){
        List<TreeNode> areaTree = areaService.findAreasByParentCode(parentCode);
        return ResultBody.success(areaTree);
    }
}
