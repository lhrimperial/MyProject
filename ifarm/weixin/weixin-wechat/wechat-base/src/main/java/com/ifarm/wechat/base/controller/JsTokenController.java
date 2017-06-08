package com.ifarm.wechat.base.controller;

import com.handy.frame.util.FastJsonUtil;
import com.ifarm.wechat.base.entity.token.JsToken;
import com.ifarm.wechat.base.util.JsTokenUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lhr
 * @create 2017/5/9 22:29
 */
@Controller
@RequestMapping("/jsToken")
public class JsTokenController {

    private Logger logger = Logger.getLogger(JsTokenController.class);

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public JsToken getJsToken(@RequestBody String targetUrl){
        JsToken token = JsTokenUtil.genSign(targetUrl);
        logger.info(FastJsonUtil.toJsonString(token));
        return token;
    }


}
