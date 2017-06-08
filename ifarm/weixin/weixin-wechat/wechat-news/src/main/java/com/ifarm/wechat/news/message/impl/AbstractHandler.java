package com.ifarm.wechat.news.message.impl;

import com.handy.frame.shared.exception.BusinessException;
import com.handy.frame.util.JaxbUtil;
import com.handy.frame.util.JsonUtils;
import com.ifarm.wechat.base.define.MessageKey;
import com.ifarm.wechat.base.entity.resp.text.ResTextMsg;
import com.ifarm.wechat.base.exception.XmlTranslateException;
import com.ifarm.wechat.news.message.IMsgHandler;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.util.Date;
import java.util.Map;


public abstract class AbstractHandler implements IMsgHandler {
	
	private Logger logger = Logger.getLogger(AbstractHandler.class);

	@Override
	public String handleMsg(Map<String, String> inputParams) throws BusinessException {
		String rtn = "";
		ResTextMsg textMessage = new ResTextMsg();
		textMessage.setToUserName(inputParams.get("FromUserName"));  
	    textMessage.setFromUserName(inputParams.get("ToUserName"));  
	    textMessage.setCreateTime(new Date().getTime());  
	    textMessage.setMsgType(MessageKey.RESP_MSG_TYPE_TEXT);
	    textMessage.setContent(getContent(inputParams));
	    logger.info(JsonUtils.toJson(textMessage));
	    try {
			rtn = JaxbUtil.marshToXmlBinding(ResTextMsg.class, textMessage);
		} catch (JAXBException e) {
			logger.info("转换异常。。。。。。。。。。。。。。。");
			throw new XmlTranslateException("XML转换异常", e);
		}
	    logger.info(rtn);
		return rtn;
	}
	
	public abstract String getContent(Map<String, String> inputPara);

}
