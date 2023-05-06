package com.wxq.mall.utils;

import com.rabbitmq.client.*;
import com.wxq.mall.system.MallProperties;
import com.wxq.mall.system.RabbitMqProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeoutException;

/**
 * @author weixiaoqiang
 * @date 2023/4/23
 **/
@Component
public class RabbitMqUtil implements InitializingBean {

    private static ConnectionFactory factory;

    @Resource
    private MallProperties mallProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        RabbitMqProperties rabbitmq = mallProperties.getRabbitmq();
        factory = new ConnectionFactory();
        //设置连接rabbitmq主机
        factory.setHost(rabbitmq.getHost());
        //设置连接rabbitmq端口
        factory.setPort(rabbitmq.getPort());
        //设置连接哪个虚拟主机
        factory.setVirtualHost("/mirror");
        //设置访问虚拟主机的用户名
        factory.setUsername(rabbitmq.getUsername());
        //设置访问虚拟主机的密码
        factory.setPassword(rabbitmq.getPassword());
    }

    public Connection getConnection() throws IOException, TimeoutException {
        return factory.newConnection();
    }
}
