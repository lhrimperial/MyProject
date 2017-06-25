package com.handy.frame.web.activemq.impl;

import com.handy.frame.web.activemq.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author longhairen
 * @create 2017/6/21 0021 下午 3:25
 */
@Service("objectProcerSrevice")
public class ObjectProducerServiceImpl implements ProducerService {

    @Autowired
    @Qualifier("objectJmsTemplate")
    private JmsTemplate objectJmsTemplate;

    @Override
    public void sendMessage(Object object) {
        System.out.println("send object message");
        objectJmsTemplate.convertAndSend(object);
    }
}
