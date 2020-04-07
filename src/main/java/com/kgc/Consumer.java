package com.kgc;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer
{
    public static void getMessage()throws Exception
    {
        Connection connection = ConnectionUtil.getConnection();
        final Channel channel = connection.createChannel();
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body, "UTF-8"));
                System.out.println("消息消费成功，告诉rabbitmq消费已经消费");
                //确认消息消费成功，第一个参数是消息的唯一表示，第二个参数表示是否是批量确认
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        // channel.basicConsume(ConnectionUtil.QUEUE_NAME,true,defaultConsumer);
        //中间的参数默认是fasle，代表要收到告诉rabbitmq我已经消费完毕
        //rabbitmq存在一直机制，可能在消费者消费信息的时候，发生错误，如果rabbitmq中把这个
        //信息移除掉的话，就会发生消息丢失问题，所以rabbitmq，默认的是当消费者消费完信息后
        //要告诉rabbitmq我已经消费完毕，可以消息移除了。
        //当改为true的时候，只要消费者拿到消息，不管出不出错，rabbitmq多会吧消息移除掉
        //

        channel.basicConsume(ConnectionUtil.QUEUE_NAME,defaultConsumer);
    }





















}
