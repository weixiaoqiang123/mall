package com.wxq.mall.system.swagger;

import lombok.Builder;
import lombok.Data;

/**
 * @author weixiaoqiang
 * @date 2023/4/15
 **/
@Data
@Builder
// @EqualsAndHashCode(callSuper = false)
public class SwaggerProperties {

    // 文档生成基础路径
    private String apiBasePackages;

    // 是否启用登录认证
    private boolean enableSecurity;

    // 文档标题
    private String title;

    // 文档描述
    private String description;

    // 文档版本
    private String version;

    // 文档联系人姓名
    private String concatName;

    // 文档联系人网址
    private String concatUrl;

    // 文档联系人邮箱
    private String concatEmail;
}
