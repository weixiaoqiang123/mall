package com.wxq.mall.type;

import com.wxq.mall.exception.BaseException;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 *
 * add: 拥有新增类型按钮权限，例如:：新增用户、新增菜单
 * update：拥有修改类型按钮权限，例如：修改用户、修改菜单、发布、下限
 * delete: 拥有删除类型按钮权限，例如：注销用户
 * view: 拥有查看类型按钮前看，例如：预览，查看详情
 **/
public enum ButtonAuthType {

    ADD("add"),

    UPDATE("update"),

    DELETE("delete"),

    VIEW("view");

    private String buttonType;

    ButtonAuthType(String buttonType){
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return buttonType;
    }

    public static ButtonAuthType of(String buttonType){
        Optional<ButtonAuthType> result = Arrays.asList(values()).stream().filter(type -> type.buttonType.equals(buttonType)).findFirst();
        if(result.isPresent()) {
            throw new BaseException("Invalid button type: " + buttonType);
        }
        return result.get();
    }
}
