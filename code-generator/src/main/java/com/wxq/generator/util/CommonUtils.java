package com.wxq.generator.util;

/**
 * @author weixiaoqiang
 * @date 2023/4/10
 **/
public class CommonUtils {

    public static String firstCharLowerCase(String str){
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String humpToLine(String str){
        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            String s = new Character(ch).toString();
            boolean isUpperCase = Character.isUpperCase(ch);
            if(i > 0 && isUpperCase){
                builder.append("_");
            }
            String letter = isUpperCase ? s.toLowerCase() : s;
            builder.append(letter);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(humpToLine("CmsArea"));
    }
}
