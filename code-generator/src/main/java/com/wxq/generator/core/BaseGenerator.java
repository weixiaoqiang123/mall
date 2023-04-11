package com.wxq.generator.core;

import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.wxq.common.model.ResultBody;
import com.wxq.common.utils.CommonUtils;
import java.util.Collections;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023/4/10
 **/
public class BaseGenerator {

    private static DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/mall","root","123456");
    private static String WORK_SPACE = System.getProperty("user.dir");
    private static String OUTPUT_DIR = WORK_SPACE + "/code";

    protected static StrategyConfig.Builder strategyConfig(StrategyConfig.Builder builder) {
        builder.entityBuilder().enableRemoveIsPrefix().enableTableFieldAnnotation();
        builder.mapperBuilder().enableBaseResultMap().enableMapperAnnotation();
        return builder;
    }

    /**
     * 全局配置
     */
    protected static GlobalConfig.Builder globalConfig(GlobalConfig.Builder builder) {
        System.out.println(OUTPUT_DIR);
        return builder
                .fileOverride()
                .outputDir(OUTPUT_DIR)
                .author("sys")
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .enableSwagger()
                .commentDate("yyyy-MM-dd");
    }

    /**
     * 包配置
     */
    protected static PackageConfig.Builder packageConfig(PackageConfig.Builder builder) {
        return builder
                .parent("com.wxq.mall")
                .entity("model")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("xml")
                .controller("controller");
    }

    protected static InjectionConfig.Builder injectConfig(InjectionConfig.Builder builder) {
        return builder.beforeOutputFile(((tableInfo, stringObjectMap) -> {
            String serviceName = tableInfo.getServiceName();
            String mapperName = tableInfo.getMapperName();
            String entityName = tableInfo.getEntityName();

            // IUserService => beanName: userService;
            String serviceBeanName = CommonUtils.firstCharLowerCase(serviceName.substring(1));
            stringObjectMap.put("serviceBeanName", serviceBeanName);

            String mapperBeanName = CommonUtils.firstCharLowerCase(mapperName);
            stringObjectMap.put("mapperBeanName", mapperBeanName);

            String entityAttrName = CommonUtils.firstCharLowerCase(entityName);
            stringObjectMap.put("entityName", entityAttrName);

            String tableName = CommonUtils.humpToLine(entityAttrName);
            stringObjectMap.put("tableName", tableName);

            BaseMethodConfig.Builder baseMethodsConfig = baseMethodsConfig();
            Map<String, Object> baseMethodsMap = baseMethodsConfig.build().toMap();
            stringObjectMap.putAll(baseMethodsMap);

            // System.out.println("tableInfo: " + tableInfo + ",objectMap: " + stringObjectMap + ", baseMethodsConfig: " + baseMethodsMap);
        })).customMap(Collections.singletonMap("test", "baomidou"));
    }

    protected static TemplateConfig.Builder templateConfig() {
        return new TemplateConfig.Builder();
    }

    protected static BaseMethodConfig.Builder baseMethodsConfig(){
        return new BaseMethodConfig.Builder().commonReturnType("ResultBody").commonResultClass(ResultBody.class);
    }

    protected static DataSourceConfig.Builder dataSourceConfig(){
        return DATA_SOURCE_CONFIG;
    }
}
