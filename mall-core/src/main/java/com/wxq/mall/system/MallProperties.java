package com.wxq.mall.system;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 *
 * Spring Boot 默认不支持@PropertySource读取yaml 文件，需要自定义PropertySourceFactory进行解析
 **/
@Component
@PropertySource(value = "classpath:mall.yaml", factory = YamlPropertiesSourceFactory.class)
@ConfigurationProperties(prefix = "mall")
@Data
public class MallProperties {

    private static final List<String> DEFAULT_EXCLUDE_PATH = new ArrayList<>();

    static {
        DEFAULT_EXCLUDE_PATH.add("/v2/**");
        DEFAULT_EXCLUDE_PATH.add("/swagger-resources/**");
        DEFAULT_EXCLUDE_PATH.add("/swagger-ui.html");
        DEFAULT_EXCLUDE_PATH.add("/webjars/**");
        DEFAULT_EXCLUDE_PATH.add("/doc.html");
    }

    @PostConstruct
    private void init() {
        excludeLoginPath.addAll(DEFAULT_EXCLUDE_PATH);
    }

    private List<String> excludeLoginPath = new ArrayList<>();

    private RabbitMqProperties rabbitmq;
}
