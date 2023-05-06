package com.wxq.mall.system.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wxq.mall.utils.RabbitMqUtil;
import org.springframework.beans.factory.SmartInitializingSingleton;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * @author weixiaoqiang
 * @date 2023/4/25
 **/
public class MessageQueueCreator implements SmartInitializingSingleton {

    @Resource
    private List<Exchange> exchanges = new ArrayList<>();

    @Resource
    private List<Queue> queues = new ArrayList<>();

    @Resource
    private List<Binding> bindings = new ArrayList<>();

    @Resource
    private RabbitMqUtil rabbitMqUtil;

    @Override
    public void afterSingletonsInstantiated() {
        createExchanges();
        createQueues();
    }

    private void createQueues(){
        for (Queue queue : queues) {
            try{
                createQueue(queue);
            }catch (Exception e){
                throw new IllegalStateException("Failed to create queue, queue name: " +
                        queue.getName(), e);
            }
        }
    }

    private void createExchanges() {
        for (Exchange exchange : exchanges) {
            try{
                createExchange(exchange);
            }catch (Exception e){
                throw new IllegalStateException("Failed to create exchange, exchange name: " +
                        exchange.getExchangeName(), e);
            }
        }
    }

    private void createExchange(Exchange exchange) throws IOException, TimeoutException {
        if(Objects.nonNull(exchange.getExchangeName())) {
            Connection connection = rabbitMqUtil.getConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(exchange.getExchangeName(), exchange.getExchangeType());
            channel.close();
            connection.close();
        }
    }

    private void createQueue(Queue queue) throws IOException, TimeoutException {
        if(Objects.nonNull(queue.getName())) {
            Connection connection = rabbitMqUtil.getConnection();
            Channel channel = connection.createChannel();
            List<Binding> bindings = this.bindings.stream().filter(binding -> binding.getQueueName().equals(queue.getName()))
                    .collect(Collectors.toList());
            channel.queueDeclare(
                    queue.getName(),
                    queue.isDurable(),
                    queue.isExclusive(),
                    queue.isAutoDelete(),
                    queue.getParams());
            for (Binding binding : bindings) {
                // queueName exchangeName routingKey headers
                channel.queueBind(binding.getQueueName(), binding.getExchangeName(), "", new HashMap<>());
            }
            channel.close();
            connection.close();
        }
    }
}
