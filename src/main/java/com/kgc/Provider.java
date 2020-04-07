package com.kgc;

import com.rabbitmq.client.*;

import java.net.Socket;


public class Provider
{

    public static void sendByExchange(String message)throws Exception
    {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(ConnectionUtil.QUEUE_NAME,true,false,false,null);
        //声明exchange
        channel.exchangeDeclare(ConnectionUtil.EXCHANGE_NAME,"fanout");
        //交换机和队列绑定
        channel.queueBind(ConnectionUtil.QUEUE_NAME,ConnectionUtil.EXCHANGE_NAME,"");

        //给交换机发送消息
        channel.basicPublish(ConnectionUtil.EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println("发送消息为："+message);
        channel.close();
        connection.close();

    }

}
