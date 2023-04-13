package com.wxq.mall.utils;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 *
 * 商品审核消息工具类
 **/
public class ProductApprovalUtil {

    // 商品审核消息模版  eg: 【商家名称】: 商品名称 待审核
    public static final String APPROVAL_MESSAGE_TEMPLATE = "<strong>【%s】</strong>: <span>%s</span> 待审核";
    // 审核结果消息模版  eg: 【商品名称】审核不通过
    public static final String APPROVAL_RESULT_MESSAGE_TEMPLATE = "【%s】<span>%s</span>";

    public static String buildApprovalMessage(String businessName, String productName) {
        return String.format(APPROVAL_MESSAGE_TEMPLATE, businessName, productName);
    }

    public static String buildApprovalResult(String productName, boolean isPass) {
        String resultMessage = isPass ? "审核通过" : "审核不通过";
        return String.format(APPROVAL_RESULT_MESSAGE_TEMPLATE, productName, resultMessage);
    }
}
