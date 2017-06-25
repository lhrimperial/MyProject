package com.handy.frame.web.util;

import com.handy.frame.util.JsonUtils;
import org.apache.log4j.Logger;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

/**
 * @author 龙海仁
 * @create：2015年12月2日 上午8:21:00
 * @description：
 */
public class MessageConvertForSys implements MessageConverter {

    private Logger logger = Logger.getLogger(MessageConvertForSys.class);

    @Override
    public Message toMessage(Object object, Session session)
            throws JMSException, MessageConversionException {
        ObjectMessage objectMessage = session.createObjectMessage();
        objectMessage.setJMSExpiration(1000);
        logger.info("[ObjectMessage]:" + object.getClass().getName());
        objectMessage.setObject((Serializable) object);
        logger.info("MQ发送的OBJECT信息：" + JsonUtils.toJson(object));
        return objectMessage;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException,
            MessageConversionException {
        ObjectMessage objectMessage = (ObjectMessage) message;
        return objectMessage.getObject();
    }

}