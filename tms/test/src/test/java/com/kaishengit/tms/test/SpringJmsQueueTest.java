package com.kaishengit.tms.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jms-queue.xml")
public class SpringJmsQueueTest {

    @Autowired
    private JmsTemplate jmsTemplate;


    //发送
    @Test
    public void sendMessage() throws InterruptedException {
        while (1==1){
            jmsTemplate.send("spring-jms", new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("哈哈，小傻瓜");
                }
            });
            Thread.sleep(5000);

        }
    }

    //读取queue里面的消息

    @Test
    public void getMessage(){
        System.out.println("spring-listener:start....");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
