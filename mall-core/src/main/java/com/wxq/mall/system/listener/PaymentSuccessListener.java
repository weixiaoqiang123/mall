package com.wxq.mall.system.listener;

import com.rabbitmq.client.*;
import com.wxq.mall.utils.Constants;
import com.wxq.mall.utils.RabbitMqUtil;
import org.springframework.context.ApplicationContext;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author weixiaoqiang
 * @date 2023/4/24
 **/
public class PaymentSuccessListener {

    @Resource
    private ApplicationContext context;

    @Resource
    private RabbitMqUtil rabbitMqUtil;

    @PostConstruct
    public void listen() throws Exception {
        Connection connection = rabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        PaymentSuccessConsumer consumer = new PaymentSuccessConsumer(channel, context);
        channel.basicConsume(Constants.PAY_SUCCESS_QUEUE, true, consumer);
    }
}
