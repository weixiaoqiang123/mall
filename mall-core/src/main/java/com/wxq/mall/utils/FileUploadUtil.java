package com.wxq.mall.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.wxq.mall.system.upload.FileUploadConfig;
import java.io.InputStream;

/**
 * @author weixiaoqiang
 * @date 2023/4/14
 **/
public class FileUploadUtil {

    // 华东
    private static final Configuration cfg = new Configuration(Region.region0());
    private static final Auth AUTH = Auth.create(FileUploadConfig.accessKey, FileUploadConfig.secretKey);
    private static final String TOKEN = AUTH.uploadToken(FileUploadConfig.bucket);
    //创建上传对象
    private static final UploadManager uploadManager = new UploadManager(cfg);
    private static final BucketManager bucketManager = new BucketManager(AUTH, cfg);

    public static String upload(String fileName, InputStream stream){
        if(stream == null){
            throw new RuntimeException("File input steam must not empty");
        }

        String filePath = FileUploadConfig.uploadDir + "/" + fileName;
        try {
            Response response = uploadManager.put(stream, filePath, TOKEN, null, null);
            String bodyString = response.bodyString();
            System.out.println(bodyString);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return FileUploadConfig.host + "/" + putRet.key;
        } catch (QiniuException e) {
            throw new RuntimeException("Failed to upload file", e);
        }
    }

    public static void delete(String url){
        String fileKey = url.substring(FileUploadConfig.host.length() + 1);
        try {
            bucketManager.delete(FileUploadConfig.bucket, fileKey);
        } catch (QiniuException e) {
            throw new RuntimeException("Failed to delete file: " + fileKey, e);
        }
    }
}
