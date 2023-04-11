package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.OmsOrderDetail;
import com.wxq.mall.service.IOmsOrderDetailService;
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
@RequestMapping("/oms-order-detail")
public class OmsOrderDetailController {

    @Resource
    private IOmsOrderDetailService omsOrderDetailService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody OmsOrderDetail omsOrderDetail) {
        omsOrderDetailService.add(omsOrderDetail);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody OmsOrderDetail omsOrderDetail) {
        omsOrderDetailService.update(omsOrderDetail);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        omsOrderDetailService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        OmsOrderDetail entity = omsOrderDetailService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<OmsOrderDetail> pageModel = omsOrderDetailService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<OmsOrderDetail> data = omsOrderDetailService.findAll();
        return ResultBody.success(data);
    }
}
