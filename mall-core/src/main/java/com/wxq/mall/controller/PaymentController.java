package com.wxq.mall.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wxq.mall.exception.BaseException;
import com.wxq.mall.model.OmsOrder;
import com.wxq.mall.service.IOmsOrderService;
import com.wxq.mall.system.pay.AlipayProperties;
import com.wxq.mall.system.pay.PayManager;
import com.wxq.mall.system.pay.PayMethod;
import com.wxq.mall.utils.Assert;
import com.wxq.mall.utils.Constants;
import com.wxq.mall.utils.RabbitMqUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author weixiaoqiang
 * @date 2023/4/12
 **/
@Controller
@RequestMapping("/payment")
@Api(tags = "用户支付")
@Slf4j
public class PaymentController {

    @Resource
    private PayManager payManager;

    @Resource
    private RabbitMqUtil rabbitMqUtil;

    @Resource
    private AlipayClient alipayClient;

    @GetMapping("/submit")
    @ApiOperation("发起支付")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单编号"),
            @ApiImplicitParam(name = "totalAmount", value = "订单金额"),
            @ApiImplicitParam(name = "subject", value = "标题"),
            @ApiImplicitParam(name = "payCode", value = "支付方式编码", defaultValue = "alipay")
    })
    public String submit(HttpServletRequest request){
        // 获取支付方式 跳转对应地址
        String orderId = request.getParameter("orderId");
        // 获取支付方式编码
        String payCode = request.getParameter("payCode");
        Assert.notNull(orderId, new BaseException("The order id must be not null"));
        Assert.notNull(payCode, new BaseException("The payment organization must be not null"));
        PayMethod payMethod = payManager.getInstance(payCode);
        return "forward:" + payMethod.actionUrl();
    }

    @GetMapping("/alipay")
    public void aliPay(HttpServletRequest request, HttpServletResponse response) {
        //创建支付记录
        String orderId = request.getParameter("orderId");
        // 获取订单金额
        String totalAmount = request.getParameter("totalAmount");
        // 获取标题
        String subject = request.getParameter("subject");
        //创建API对应的request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 设置同步回调
        // alipayRequest.setReturnUrl(AlipayConfig.return_payment_url);
        // 设置异步回调
        alipayRequest.setNotifyUrl("http://nskq43.natappfree.cc/payment/callback/notify");
        // 声明一个map 集合来存储参数
        Map<String, Object> map = new HashMap<>();
        map.put("out_trade_no",orderId);
        map.put("product_code","FAST_INSTANT_TRADE_PAY");
        map.put("total_amount", totalAmount);
        map.put("subject", subject);
        // 将封装好的参数传递给支付宝！
        alipayRequest.setBizContent(JSON.toJSONString(map));
        String form="";
        try {
            //调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        try {
            //直接将完整的表单html输出到页面
            response.getWriter().write(form);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/wechat")
    public void wechatPay(HttpServletRequest request) {

    }

    // 支付成功后的异步回调，用于接收支付宝返回的支付结果
    @RequestMapping("/callback/notify")
    @ResponseBody
    public String callbackNotify(@RequestParam Map<String,String> paramMap, HttpServletRequest request, HttpServletResponse response){
        log.info("params: {}", paramMap);
        String orderId = paramMap.get("out_trade_no");
        //调用SDK验证签名
        boolean flag = false;
        try {
            flag = AlipaySignature.rsaCheckV1(paramMap, AlipayProperties.alipayPublicKey, "utf-8", "RSA2");
        } catch (AlipayApiException e) {
            log.error("payment failure, order id: {}, reason: {}", orderId, e);
            return "failure";
        }

        String result = "failure";
        // 验签成功
        // todo 为什么验签失败
        if(flag) {
            // tradeStatus=TRADE_SUCCESS || TRADE_FINISHED 表示支付成功
            String tradeStatus = paramMap.get("trade_status");
            // 支付宝交易流水号
            String tradeNo = paramMap.get("trade_no");

            if(tradeStatus.equals("TRADE_SUCCESS") || tradeStatus.equals("TRADE_FINISHED")) {

                try {
                    Connection connection = rabbitMqUtil.getConnection();
                    Channel channel = connection.createChannel();
                    channel.basicPublish(Constants.PAY_RESULT_EXCHANGE, "", null, orderId.getBytes(StandardCharsets.UTF_8));
                    result = "success";
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    log.error("Rabbitmq connect time out",e);
                }
            } else {
                log.error("Failed to pay");
            }
        } else {
            log.error("Failed to check signature");
        }
        return result;
    }
}
