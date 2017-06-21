package com.handy.frame.web.activemq;

import com.handy.frame.util.JsonUtils;
import com.handy.frame.web.domain.UserInfo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * @author longhairen
 * @create 2017/6/21 0021 下午 3:50
 */
public class ObjectMessageListener implements MessageListener {

    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                UserInfo user = (UserInfo) objectMessage.getObject();
                System.out.println(JsonUtils.toJson(user));
            }
        } catch(JMSException e){
            e.printStackTrace();
        }
    }
}
