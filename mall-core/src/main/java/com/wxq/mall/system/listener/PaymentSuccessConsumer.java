package com.wxq.mall.system.listener;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.wxq.mall.mapper.OmsOrderMapper;
import com.wxq.mall.model.OmsOrder;
import com.wxq.mall.type.order.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author weixiaoqiang
 * @date 2023/4/24
 **/
@Slf4j
public class PaymentSuccessConsumer extends DefaultConsumer {

    private ApplicationContext context;

    private OmsOrderMapper orderMapper;

    public PaymentSuccessConsumer(Channel channel, ApplicationContext context) {
        super(channel);
        this.context = context;
    }


    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        Channel channel = super.getChannel();
        long deliveryTag = envelope.getDeliveryTag();
        String orderId = new String(body, StandardCharsets.UTF_8);
        try{
            OmsOrder order = orderMapper.selectById(orderId);
            // 修改订单状态
            // todo 可使用队列模拟发货-到店-收货过程 暂时支付成功后直接发货到店 用户手动确认收货
            order.setStatus(OrderStatus.DELIVERED.getStatus());
            orderMapper.updateById(order);
            // 答复
            channel.basicAck(deliveryTag, false);
        }catch (Exception e){
            log.error("Failed to update product status", e);
            // 出错 不答复 再次消费
        }
    }




    private void prepared() {
        orderMapper = context.getBean(OmsOrderMapper.class);
    }
}
