package com.handy.frame.activemq;

import com.handy.frame.util.JsonUtils;
import com.handy.frame.web.domain.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.jms.Message;
import javax.jms.ObjectMessage;

/**
 * @author longhairen
 * @create 2017/6/21 0021 下午 4:01
 */
@ContextConfiguration("classpath*:spring-activemq-consumer.xml")
public class ConsumerTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void test() throws Exception{
        Message message = jmsTemplate.receive();
        ObjectMessage objectMessage = (ObjectMessage) message;
        UserInfo user = (UserInfo) objectMessage.getObject();
        System.out.println(JsonUtils.toJson(user));
    }
}
