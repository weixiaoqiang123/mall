package com.wxq.generator.core;

import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.wxq.common.model.ResultBody;
import com.wxq.common.utils.CommonUtils;
import com.wxq.generator.convert.NameStrategy;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author weixiaoqiang
 * @date 2023/4/10
 **/
public class BaseGenerator {

    private static DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/mall","root","123456");
    private static String WORK_SPACE = System.getProperty("user.dir");
    private static String OUTPUT_DIR = WORK_SPACE + "/code";

    protected static StrategyConfig.Builder strategyConfig(StrategyConfig.Builder builder) {
        builder.entityBuilder().enableRemoveIsPrefix().enableTableFieldAnnotation().nameConvert(nameConfig().build());
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
            changeDateFieldType(tableInfo);

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

    protected static NameStrategy.Builder nameConfig(){
        return new NameStrategy.Builder();
    }

    private static void changeDateFieldType(TableInfo tableInfo) {
        List<TableField> fields = tableInfo.getFields().stream()
                .filter(field -> isDateField(field))
                .collect(Collectors.toList());

        for (TableField field : fields) {
            Class<? extends TableField> clazz = field.getClass();
            try {
                Field columnType = clazz.getDeclaredField("columnType");
                columnType.setAccessible(true);
                columnType.set(field, DbColumnType.DATE);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Class<? extends TableInfo> clazz = tableInfo.getClass();
        try {
            Field importPackagesField = clazz.getDeclaredField("importPackages");
            importPackagesField.setAccessible(true);
            Set<String> importPackages = (Set<String>) importPackagesField.get(tableInfo);
            importPackages.remove(DbColumnType.LOCAL_DATE.getPkg());
            importPackages.remove(DbColumnType.LOCAL_TIME.getPkg());
            importPackages.remove(DbColumnType.LOCAL_DATE_TIME.getPkg());
            importPackages.add(DbColumnType.DATE.getPkg());
            importPackagesField.set(tableInfo, importPackages);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static boolean isDateField(TableField field) {
        return field.getColumnType().getType().equals(DbColumnType.LOCAL_DATE_TIME.getType()) ||
                field.getColumnType().getType().equals(DbColumnType.LOCAL_DATE.getType()) ||
                        field.getColumnType().getType().equals(DbColumnType.LOCAL_TIME);
    }
}
