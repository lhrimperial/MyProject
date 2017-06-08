package com.ifarm.wechat.news.message.impl;

import com.handy.frame.util.JsonUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class VideoMsgHandler extends AbstractHandler {
	
	private Logger logger = Logger.getLogger(VideoMsgHandler.class);

	@Override
	public String getContent(Map<String, String> inputPara) {
		logger.debug(JsonUtils.toJson(inputPara));
		return "视频文件已收到！";
	}
}
