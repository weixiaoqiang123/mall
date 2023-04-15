package com.wxq.mall.system.upload;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author weixiaoqiang
 * @date 2023/4/14
 **/
public class FileUploadConfig {

    static {
        Properties properties = new Properties();
        InputStream resource = FileUploadConfig.class.getClassLoader().getResourceAsStream("upload.properties");
        try {
            properties.load(resource);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read config file");
        }

        accessKey = (String) properties.get("upload.accessKey");
        secretKey = (String) properties.get("upload.secretKey");
        uploadDir = (String) properties.get("upload.uploadDir");
        host = (String) properties.get("upload.host");
        bucket = (String) properties.get("upload.bucket");
    }

    public static String accessKey;

    public static String secretKey;

    public static String uploadDir;

    public static String host;

    public static String bucket;
}
