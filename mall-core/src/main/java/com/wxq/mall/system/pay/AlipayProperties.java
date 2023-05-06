package com.wxq.mall.system.pay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author weixiaoqiang
 * @date 2023/4/15
 **/
@Component
public class AlipayProperties {

    @Resource
    private Environment environment;

    public static String appId;

    public static String appPrivateKey;

    public static String alipayPublicKey;

    public static String url;

    @PostConstruct
    public void init(){
        environment.getProperty("appId");
    }

    @Value("${alipay.appId}")
    public void setAppId(String appId) {
        AlipayProperties.appId = appId;
    }

    @Value("${alipay.appPrivateKey}")
    public void setAppPrivateKey(String appPrivateKey) {
        AlipayProperties.appPrivateKey = appPrivateKey;
    }

    @Value("${alipay.alipayPublicKey}")
    public void setAlipayPublicKey(String alipayPublicKey) {
        AlipayProperties.alipayPublicKey = alipayPublicKey;
    }

    @Value("${alipay.url}")
    public void setUrl(String url) {
        AlipayProperties.url = url;
    }
}
