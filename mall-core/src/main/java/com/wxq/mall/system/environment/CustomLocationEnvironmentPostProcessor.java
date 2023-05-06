package com.wxq.mall.system.environment;

import com.wxq.mall.system.YamlPropertiesSourceFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Profiles;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.*;
import org.springframework.core.io.support.EncodedResource;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author weixiaoqiang
 * @date 2023/4/16
 **/
public class CustomLocationEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private static final String WORKSPACE_DIR = System.getProperty("user.dir");
    private static final String RESOURCE_DIR = "/local/config";

    // 如何拿到spring bean
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        boolean isProd = environment.acceptsProfiles(Profiles.of("prod"));
        String name = "alipayPropertySource";
        Resource resource = null;
        if(isProd) {
            resource = new DefaultResourceLoader().getResource("classpath:alipay.yaml");
        } else {
            String resourcePath = WORKSPACE_DIR + RESOURCE_DIR + "/alipay.yaml";
            try {
                resource = new FileUrlResource(resourcePath);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        YamlPropertiesSourceFactory factory = BeanUtils.instantiateClass(YamlPropertiesSourceFactory.class);
        PropertySource<?> propertySource = null;
        try {
            propertySource = factory.createPropertySource(name, new EncodedResource(resource, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        environment.getPropertySources().addLast(propertySource);
    }
}
