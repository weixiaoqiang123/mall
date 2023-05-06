package com.wxq.mall.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author weixiaoqiang
 * @date 2023/4/22
 **/
public class OrderCodeUtil {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String genCode(){
        String date = FORMATTER.format(new Date());
        return date + getRandom(6);
    }

    private static String getRandom(int bit) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < bit; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            System.out.println(genCode());
        }
    }
}
