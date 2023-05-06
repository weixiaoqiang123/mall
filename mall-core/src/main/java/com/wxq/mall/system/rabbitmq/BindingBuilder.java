package com.wxq.mall.system.rabbitmq;

import sun.security.krb5.internal.crypto.Des;

/**
 * @author weixiaoqiang
 * @date 2023/4/25
 **/
public class BindingBuilder {

    public static final class DestinationConfigurer {

        private Queue queue;

        public DestinationConfigurer(Queue queue) {
            this.queue = queue;
        }

        public Binding to(Exchange exchange) {
            return new Binding(queue.getName(), exchange.getExchangeName());
        }
    }

    public static DestinationConfigurer bind(Queue queue) {
        return new DestinationConfigurer(queue);
    }
}
