package com.wxq.generator.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023/4/10
 **/
public class BaseMethodConfig {

    private List<String> baseMethods = new ArrayList<>();

    private String commonReturnType = "Object";

    private String commonResultType = "ResponseEntity";

    private String commonResultClass = "org.springframework.http.ResponseEntity";

    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("baseMethods", baseMethods);
        map.put("commonReturnType", commonReturnType);
        map.put("commonResultType", commonResultType);
        map.put("commonResultClass", commonResultClass);
        return map;
    }

    public static class Builder {

        private final BaseMethodConfig baseMethodConfig = new BaseMethodConfig();

        public Builder(){
            for (BaseMethods method : BaseMethods.all()) {
                this.addMethod(method);
            }
        }

        public Builder addMethod(BaseMethods baseMethods) {
            this.baseMethodConfig.baseMethods.add(baseMethods.getMethodName());
            return this;
        }

        public Builder commonReturnType(String name){
            this.baseMethodConfig.commonReturnType = name;
            return this;
        }

        public Builder commonResultClass(Class clazz){
            if(clazz != null){
                this.baseMethodConfig.commonReturnType = clazz.getSimpleName();
                this.baseMethodConfig.commonResultClass = clazz.getName();
            }
            return this;
        }

        public BaseMethodConfig build(){
            return baseMethodConfig;
        }
    }
}
