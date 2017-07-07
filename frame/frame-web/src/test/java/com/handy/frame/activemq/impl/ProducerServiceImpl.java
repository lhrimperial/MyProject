package com.handy.frame.activemq.impl;

import com.handy.frame.activemq.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author longhairen
 * @create 2017/6/21 0021 上午 11:39
 */
@Service("textProcerService")
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    @Qualifier("textJmsTemplate")
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("textDestination")
    private ActiveMQQueue textDestination;

    public void sendMessage(final Object message) {
        System.out.println("---------------生产者发送消息-----------------");
        System.out.println("---------------生产者发了一个消息：" + message);
        jmsTemplate.send(textDestination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message.toString());
            }
        });
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public ActiveMQQueue getTextDestination() {
        return textDestination;
    }

    public void setTextDestination(ActiveMQQueue textDestination) {
        this.textDestination = textDestination;
    }
}
