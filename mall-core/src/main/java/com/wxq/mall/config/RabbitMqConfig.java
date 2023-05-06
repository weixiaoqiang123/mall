package com.wxq.mall.config;

import com.wxq.mall.system.listener.AutoCancelOrderListener;
import com.wxq.mall.system.listener.PaymentSuccessListener;
import com.wxq.mall.system.rabbitmq.*;
import com.wxq.mall.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weixiaoqiang
 * @date 2023/4/25
 **/
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue paySuccessQueue(){
        return new Queue(Constants.PAY_SUCCESS_QUEUE).durable(true);
    }

    @Bean
    public Queue orderQueue(){
        return new Queue(Constants.ORDER_QUEUE)
                .durable(true)
                .addParams("x-message-ttl", Constants.ORDER_EXPIRE_TIME)
                .addParams("x-dead-letter-exchange", Constants.ORDER_TIME_OUT_QUEUE);
    }

    @Bean
    public Queue orderTimeOutQueue(){
        // 订单队列的死信队列 实现延迟队列功能
        return new Queue(Constants.ORDER_TIME_OUT_QUEUE).durable(true);
    }

    @Bean
    public Exchange payResultExchange(){
        return new Exchange(Constants.PAY_RESULT_EXCHANGE, "fanout");
    }

    @Bean
    public Binding paySuccessToPayResultExchange(){
        return BindingBuilder.bind(paySuccessQueue()).to(payResultExchange());
    }

    @Bean
    public MessageQueueCreator messageQueueCreator(){
        return new MessageQueueCreator();
    }

    @Bean
    public AutoCancelOrderListener autoCancelOrderListener(){
        return new AutoCancelOrderListener();
    }

    @Bean
    public PaymentSuccessListener paymentSuccessListener(){
        return new PaymentSuccessListener();
    }
}
