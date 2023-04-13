package com.wxq.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.PmsProductApproval;
import com.wxq.mall.service.IPmsProductApprovalService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import java.util.List;
import org.springframework.stereotype.Controller;
import com.wxq.common.model.ResultBody;

/**
 * @author weixiaoqiang
 * @date 2023-04-13
 */
@Controller
@RequestMapping("/pms-product-approval")
@Api(tags = "商品审核管理")
public class PmsProductApprovalController {

    @Resource
    private IPmsProductApprovalService productApprovalService;

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<PmsProductApproval> pageModel = productApprovalService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<PmsProductApproval> data = productApprovalService.findAll();
        return ResultBody.success(data);
    }

    @PostMapping("/approval-product")
    @ResponseBody
    @ApiOperation("审核商品")
    public ResultBody approvalProduct(@RequestBody PmsProductApproval pmsProductApproval){
        productApprovalService.approvalProduct(pmsProductApproval);
        return ResultBody.success();
    }
}
