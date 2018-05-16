package com.kaishengit.tms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SpringTopicListener implements MessageListener{
    @Override
    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;

        try {
            String content = textMessage.getText();
            System.out.println(content);
            System.out.println("我是topic的test"+"当前线程"+Thread.currentThread().getName()+"当前时间" +System.currentTimeMillis());

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
