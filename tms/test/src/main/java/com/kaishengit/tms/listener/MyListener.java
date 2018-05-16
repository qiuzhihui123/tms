package com.kaishengit.tms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;
import java.util.Date;

public class MyListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            String content = textMessage.getText();
            System.out.println(content + "当前线程名称" + Thread.currentThread().getName() + "当前时间" +new Date().getTime());
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
