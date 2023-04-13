package com.wxq.generator.convert;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 **/
public class NameStrategy {

    public static class Builder {
        private final NameConvertChain nameConvertChain = new NameConvertChain();

        public Builder(){}

        public Builder convertEntityName(NameBuilder builder) {
            nameConvertChain.addEntityNameConvert(new EntityNameConvert(builder));
            return this;
        }

        public Builder convertPropertyName(NameBuilder builder) {
            nameConvertChain.addPropertyNameConvert(new PropertyNameConvert(builder));
            return this;
        }

        public NameConvertChain build() {
            return nameConvertChain;
        }
    }
}
