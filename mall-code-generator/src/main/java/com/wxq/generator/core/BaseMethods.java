package com.wxq.generator.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weixiaoqiang
 * @date 2023/4/10
 *
 * 基础增删改查方法名称
 **/
public enum BaseMethods {

    ADD("add"),

    UPDATE("update"),

    DELETE("delete"),

    GET("get"),

    FIND_PAGE("findByPage"),

    FIND_ALL("findAll");

    private String methodName;

    BaseMethods(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public static List<BaseMethods> all(){
        return Arrays.asList(values()).stream().collect(Collectors.toList());
    }
}
