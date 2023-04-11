package com.wxq.mall.config;

import com.wxq.mall.system.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.annotation.Resource;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Resource
    private MallProperties mallProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(mallProperties.getExcludeLoginPath());
    }
}
