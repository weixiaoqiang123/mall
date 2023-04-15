package com.wxq.mall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author weixiaoqiang
 * @date 2023/4/14
 **/
public interface IFileUploadService {

    String upload(MultipartFile file);
}
