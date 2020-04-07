package com.kgc;

public class Test
{
    public static void main(String[] args)throws Exception {
        //sendMessage();
        Consumer.getMessage();
    }

    public static void sendMessage() throws Exception {
        Provider.sendByExchange("你好");
    }
}
