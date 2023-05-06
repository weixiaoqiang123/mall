package com.wxq.mall.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.wxq.mall.system.pay.AliPay;
import com.wxq.mall.system.pay.AlipayProperties;
import com.wxq.mall.system.pay.PayMethod;
import com.wxq.mall.system.pay.WeChatPay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weixiaoqiang
 * @date 2023/4/16
 **/
@Configuration
public class PayConfig {

    @Bean
    public PayMethod alipay(){
        return new AliPay();
    }

    @Bean
    public PayMethod wechat(){
        return new WeChatPay();
    }

    @Bean
    public AlipayClient alipayClient(AlipayProperties alipayProperties){
        AlipayClient alipayClient = new DefaultAlipayClient(
                alipayProperties.url,
                alipayProperties.appId,
                alipayProperties.appPrivateKey,
                "json",
                "utf-8",
                alipayProperties.alipayPublicKey,
                "RSA2");
        return alipayClient;
    }
}
