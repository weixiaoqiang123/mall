package com.wxq.generator.convert;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 **/
public class EntityNameConvert extends SimpleNameConvert {

    private NameBuilder nameBuilder;

    public EntityNameConvert(NameBuilder nameBuilder) {
        this.nameBuilder = nameBuilder;
    }

    @Override
    public String entityNameConvert(String name) {
        return nameBuilder.build(name);
    }
}
