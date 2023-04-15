package com.wxq.mall.config;

import com.wxq.mall.system.swagger.BaseSwaggerConfig;
import com.wxq.mall.system.swagger.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author weixiaoqiang
 * @date 2023/4/14
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .title("优乐购商城接口文档")
                .description("")
                .version("v1.0.2")
                .concatName("weixiaoqiang")
                .concatEmail("")
                .enableSecurity(true)
                .build();
    }
}
