package com.wxq.mall.system.listener;

import com.rabbitmq.client.*;
import com.wxq.mall.mapper.OmsOrderMapper;
import com.wxq.mall.model.OmsOrder;
import com.wxq.mall.type.order.OrderStatus;
import com.wxq.mall.utils.Constants;
import com.wxq.mall.utils.RabbitMqUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author weixiaoqiang
 * @date 2023/4/24
 *
 * web容器销毁时销毁资源方式
 * 1. 实现SmartLifecycle
 * 2. 实现DisposableBean
 * 3. 注册jvm销毁钩子 Runtime.getRuntime().addShutdownHook(new Thread())
 **/
@Slf4j
public class AutoCancelOrderListener implements SmartLifecycle {

    private boolean isRunning;

    private Channel channel;

    private Connection connection;

    @Resource
    private OmsOrderMapper orderMapper;

    @Resource
    private RabbitMqUtil rabbitMqUtil;

    @PostConstruct
    public void listen() throws Exception {
        connection = rabbitMqUtil.getConnection();
        channel = connection.createChannel();
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String orderId = new String(body, StandardCharsets.UTF_8);
                // todo 需要控制消费速度 太快会造成数据库压力过大
                // todo 添加已取消订单 状态
                // 查询订单状态
                OmsOrder order = orderMapper.selectById(orderId);
                if(order == null){
                    log.error("The order not exists, order id: {}", orderId);
                } else {
                    // 取消订单
                    order.setStatus(OrderStatus.CANCELED.getStatus());
                    orderMapper.updateById(order);
                    log.info("The order has canceled, order id: {}", orderId);
                }
            }
        };
        channel.basicConsume(Constants.ORDER_TIME_OUT_QUEUE, true, consumer);
    }

    @Override
    public void start() {
        isRunning = true;
    }

    @Override
    public void stop() {
        try {
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            log.error("Failed to close rabbitmq connection", e);
        }
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
