package com.wxq.mall.utils;

import com.wxq.mall.exception.BaseException;
import org.springframework.lang.Nullable;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
public class Assert {

    public static void isTrue(boolean expression, BaseException e) {
        if (!expression) {
            throw e;
        }
    }

    public static void isNull(@Nullable Object object, BaseException e) {
        if (object != null) {
            throw e;
        }
    }

    public static void notNull(@Nullable Object object, BaseException e) {
        if (object == null) {
            throw e;
        }
    }
}
