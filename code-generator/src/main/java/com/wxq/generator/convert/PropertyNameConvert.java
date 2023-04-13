package com.wxq.generator.convert;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 **/
public class PropertyNameConvert extends SimpleNameConvert {

    private NameBuilder nameBuilder;

    public PropertyNameConvert(NameBuilder nameBuilder) {
        this.nameBuilder = nameBuilder;
    }

    @Override
    public String propertyNameConvert(String name) {
        return nameBuilder.build(name);
    }
}
