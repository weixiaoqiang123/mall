package com.wxq.mall.controller;

import com.wxq.common.model.ResultBody;
import com.wxq.mall.model.UmsAdmin;
import com.wxq.mall.model.UmsMember;
import com.wxq.mall.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
@RestController
@RequestMapping("/")
@Api(tags = "用户登录")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login-admin")
    @ApiOperation(value = "后台用户登录")
    public Object loginAdmin(@RequestBody UmsAdmin user){
        String token = loginService.loginAdmin(user.getUsername(), user.getPassword());
        return ResultBody.success(token);
    }

    @PostMapping("/login-member")
    @ApiOperation(value = "前台用户登录")
    public Object login(@RequestBody UmsMember user){
        String token = loginService.login(user.getUsername(), user.getPassword());
        return ResultBody.success(token);
    }

    @GetMapping("/logout-admin")
    @ApiOperation(value = "后台用户退出登录")
    public Object loginOutAdmin(){
        loginService.logoutAdmin();
        return ResultBody.success();
    }

    @GetMapping("/logout")
    @ApiOperation(value = "前台用户退出登录")
    public Object loginOut(){
        loginService.logout();
        return ResultBody.success();
    }
}
