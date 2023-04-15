package com.wxq.generator.core;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author weixiaoqiang
 * @date 2023/4/10
 **/
public class CodeGenerator extends BaseGenerator {

    public static void main(String[] args) {

        FastAutoGenerator generator = FastAutoGenerator.create(dataSourceConfig())
                .globalConfig(builder -> globalConfig(builder).author("weixiaoqiang"))
                .strategyConfig(builder -> strategyConfig(builder))
                .packageConfig(builder -> packageConfig(builder))
                .injectionConfig(builder -> injectConfig(builder))
                .templateEngine(new FreemarkerTemplateEngine());

        generator.execute();
    }
}
