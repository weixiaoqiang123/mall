package com.wxq.mall.system.swagger;

import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023/4/15
 **/
public abstract class BaseSwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        // 生成环境禁用文档
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean enableDoc = environment.acceptsProfiles(of);

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enableDoc)
                .select()
                // 扫描带ApiOperation注解的方法
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                //过滤掉所有error或error.*页面
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();

        if(swaggerProperties().isEnableSecurity()) {
            // 全局token
            docket.securitySchemes(securitySchemes()).securityContexts(securityContexts());
            // 局部token
            // Parameter tokenParam = new ParameterBuilder().name("Authorization")
            //         .parameterType("header")
            //         .modelRef(new ModelRef("string"))
            //         .description("token")
            //         .build();
            // docket.globalOperationParameters(Arrays.asList(tokenParam));
        }
        return docket;
    }

    protected abstract SwaggerProperties swaggerProperties();

    //配置文档信息
    private ApiInfo apiInfo() {
        SwaggerProperties swaggerProperties = swaggerProperties();
        Contact contact = new Contact(swaggerProperties.getConcatName(), swaggerProperties.getConcatUrl(), swaggerProperties.getConcatEmail());
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .contact(contact)
                .version(swaggerProperties.getVersion())
                .build();
    }

    private List<ApiKey> securitySchemes(){
        return Arrays.asList(new ApiKey("Authorization", "Authorization", "header"));
    }

    private List<SecurityContext> securityContexts(){
        // 设置需要登录认证的路径
        List<SecurityContext> contexts = new ArrayList<>();
        contexts.add(getContextByPath("/*/.*"));
        return contexts;
    }

    private SecurityContext getContextByPath(String pathRegex) {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultAuth(){
        List<SecurityReference> references = new ArrayList<>();
        AuthorizationScope scope = new AuthorizationScope("global", "accessEveryThing");
        AuthorizationScope[] scopes = new AuthorizationScope[]{scope};
        references.add(new SecurityReference("Authorization", scopes));
        return references;
    }
}
