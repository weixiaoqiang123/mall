package com.wxq.generator.convert;

import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.sun.istack.internal.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 **/
public class NameConvertChain implements INameConvert {

    private List<SimpleNameConvert> entityNameConverts = new ArrayList<>();

    private List<SimpleNameConvert> propertyNameConverts = new ArrayList<>();

    public NameConvertChain(){
        entityNameConverts.add(new SimpleNameConvert());
        propertyNameConverts.add(new SimpleNameConvert());
    }

    public void addEntityNameConvert(EntityNameConvert entityNameConvert) {
        entityNameConverts.add(entityNameConvert);
    }

    public void addPropertyNameConvert(PropertyNameConvert propertyNameConvert) {
        propertyNameConverts.add(propertyNameConvert);
    }

    @Override
    public @NotNull String entityNameConvert(@NotNull TableInfo tableInfo) {
        String name = tableInfo.getName();
        for (SimpleNameConvert convert : entityNameConverts) {
            name = convert.entityNameConvert(name);
        }
        return name;
    }

    @Override
    public @NotNull String propertyNameConvert(@NotNull TableField field) {
        String name = field.getName();
        for (SimpleNameConvert convert : propertyNameConverts) {
            name = convert.propertyNameConvert(name);
        }
        return name;
    }
}
