package com.ifarm.wechat.news.message.impl;

import com.handy.frame.util.JsonUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class LocationMsgHandler extends AbstractHandler {

	private Logger logger = Logger.getLogger(LocationMsgHandler.class);

	@Override
	public String getContent(Map<String, String> inputPara) {
		logger.debug(JsonUtils.toJson(inputPara));
		return "位置信息已收到！";
	}

}
