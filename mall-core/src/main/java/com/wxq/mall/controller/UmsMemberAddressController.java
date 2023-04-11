package com.wxq.mall.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.model.UmsMemberAddress;
import com.wxq.mall.service.IUmsMemberAddressService;
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
@RequestMapping("/ums-member-address")
public class UmsMemberAddressController {

    @Resource
    private IUmsMemberAddressService umsMemberAddressService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@RequestBody UmsMemberAddress umsMemberAddress) {
        umsMemberAddressService.add(umsMemberAddress);
        return ResultBody.success();
    }

    @PutMapping
    @ResponseBody
    public ResultBody update(@RequestBody UmsMemberAddress umsMemberAddress) {
        umsMemberAddressService.update(umsMemberAddress);
        return ResultBody.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody delete(@PathVariable String id) {
        umsMemberAddressService.delete(id);
        return ResultBody.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody get(@PathVariable String id) {
        UmsMemberAddress entity = umsMemberAddressService.get(id);
        return ResultBody.success(entity);
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResultBody findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<UmsMemberAddress> pageModel = umsMemberAddressService.findByPage(params, page, size);
        return ResultBody.success(pageModel);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBody findAll() {
        List<UmsMemberAddress> data = umsMemberAddressService.findAll();
        return ResultBody.success(data);
    }
}
