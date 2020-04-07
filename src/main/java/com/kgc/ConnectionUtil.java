package com.kgc;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil
{
    public static final String QUEUE_NAME="testQueue";
    public static final String EXCHANGE_NAME="exchange";

    public static Connection getConnection()throws Exception
    {
        //创建一个连接工厂
        ConnectionFactory connectionFactory=new ConnectionFactory();
        //设置rabbitmq 服务端所在地址  我们这里在本地就是本地
        connectionFactory.setHost("127.0.0.1");
        //设置端口名 连接用户名  虚拟地址等
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("test");
        connectionFactory.setPassword("test");
        connectionFactory.setVirtualHost("/test");
        return connectionFactory.newConnection();
    }




















}
