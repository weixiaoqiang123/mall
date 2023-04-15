package com.wxq.mall.service.impl;

import com.wxq.mall.service.IFileUploadService;
import com.wxq.mall.utils.FileUploadUtil;
import com.wxq.mall.utils.SimpleKeyUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author weixiaoqiang
 * @date 2023/4/14
 **/
@Service
public class FileUploadServiceImpl implements IFileUploadService {

    @Override
    public String upload(MultipartFile file) {
        String fileId = SimpleKeyUtil.genUUID();
        String originalFilename = file.getOriginalFilename();
        String fileSuffix = originalFilename.substring(originalFilename.indexOf(".") + 1);
        String fileName = fileId + "." + fileSuffix;
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = FileUploadUtil.upload(fileName, inputStream);
        return url;
    }
}
