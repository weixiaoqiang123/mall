package com.wxq.mall.controller;

import com.wxq.common.model.ResultBody;
import com.wxq.mall.service.IFileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;

/**
 * @author weixiaoqiang
 * @date 2023/4/14
 *
 **/
@RestController
@Api(tags = "文件管理")
@RequestMapping("/file")
public class FileUploadController {

    @Resource
    private IFileUploadService uploadService;

    @PostMapping("/upload")
    @ApiOperation("上传文件")
    public Object upload(@RequestBody MultipartFile file) {
        String url = uploadService.upload(file);
        return ResultBody.success(url);
    }
}
