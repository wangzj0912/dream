package com.financeserver.wzj.finance.rabbitmq.producer;

import com.financeserver.wzj.finance.config.RabbitMqConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqProducer {
    private final static String QUEUE = "firstMQ";

    @Autowired
    private static RabbitMqConfig rabbitMqConfig;

    public static void main(String[] args) {
        Connection connection = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(rabbitMqConfig.getHost());
            factory.setPort(rabbitMqConfig.getPort());
            factory.setUsername(rabbitMqConfig.getUsername());
            factory.setPassword(rabbitMqConfig.getPassword());
            // rabbitmq默认虚拟机的名字是'/'  虚拟机相当于一个独立的mq服务器
            factory.setVirtualHost("/");

            // 创建与rabbitmq服务的TCP链接
            connection = factory.newConnection();
            // 创建与交换机(Exchange)的通道,每条链接可以创建多个通道，每个通道代表一个会话任务
            Channel channel = connection.createChannel();
            /**
             * 声明队列，如果mq没有此队列将自动创建
             * param1:队列名称
             * param2:是否持久化
             * param3:队列是否独占此链接
             * param4:队列不在使用是否自动删除
             * param5:队列参数
             */
            channel.queueDeclare(QUEUE, true, false, false, null);


        } catch (TimeoutException | IOException e) {
            e.printStackTrace();
        } finally {

        }


    }

}
