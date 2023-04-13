package com.wxq.mall.config;

import com.wxq.mall.system.cache.ProductApprovalUserCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 *
 * 全局缓存配置
 **/
@Configuration
public class GlobalCacheConfig {

    @Bean
    public ProductApprovalUserCache approvalUserCache(){
        return new ProductApprovalUserCache();
    }
}
