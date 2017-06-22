package com.handy.frame.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author longhairen
 * @create 2017/6/22 0022 下午 4:14
 */
public class Consumer {

    public static final String brokerURL = "tcp://192.168.157.128:61616";

    private ConnectionFactory factory;
    private Connection connection;
    private Session session;

    public Consumer() throws JMSException {
        factory = new ActiveMQConnectionFactory(brokerURL);
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public static void main(String[] args) throws JMSException {
        Consumer consumer = new Consumer();
        String[] arr = {"hello,world"};
        for (String stock : arr) {
            Destination destination = consumer.getSession().createTopic("STOCKS." + stock);
            MessageConsumer messageConsumer = consumer.getSession().createConsumer(destination);
            messageConsumer.setMessageListener(new Listener());
        }
    }

    public Session getSession() {
        return session;
    }
}
