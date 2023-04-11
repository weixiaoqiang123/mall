package com.wxq.mall.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
@Configuration
@PropertySource("classpath:mall.yaml")
@ConfigurationProperties(prefix = "mall")
@Data
public class MallProperties {

    private List<String> excludeLoginPath = new ArrayList<>();
}
