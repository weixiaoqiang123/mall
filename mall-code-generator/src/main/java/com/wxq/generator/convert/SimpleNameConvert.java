package com.wxq.generator.convert;

import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 **/
public class SimpleNameConvert {

    public String entityNameConvert(String name){
        return NamingStrategy.capitalFirst(NamingStrategy.underlineToCamel(name));
    }

    public String propertyNameConvert(String name){
        return NamingStrategy.underlineToCamel(name);
    }
}
