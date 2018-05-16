package com.kaishengit.tms.test;


import org.apache.activemq.command.ActiveMQTempTopic;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jms-topic.xml")
public class SpringJmsTopicTest {

    @Autowired
    private JmsTemplate jmsTemplate;


    @Test
    public void sendMessage() throws InterruptedException {

        Destination destination = new ActiveMQTopic("spring-topic");
        for(;;){
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("哈哈哈，小赤佬");
                }

            });

            Thread.sleep(3000);
        }

    }


    @Test
    public void oneMoreConsumer(){

    }

}
