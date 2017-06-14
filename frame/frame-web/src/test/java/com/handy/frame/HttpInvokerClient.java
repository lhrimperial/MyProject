package com.handy.frame;

import com.handy.frame.util.FastJsonUtil;
import com.handy.frame.web.domain.UserInfo;
import com.handy.frame.web.service.IHttpInvokerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author longhairen
 * @create 2017/6/14 0014 下午 5:02
 */
@ContextConfiguration("classpath*:spring-httpinvoker-client.xml")
public class HttpInvokerClient extends AbstractJUnit4SpringContextTests {

    @Autowired
    @Qualifier("httpService")
    private IHttpInvokerService httpService;

    @Test
    public void test(){
        UserInfo info = httpService.findUserById(1);
        System.out.println(FastJsonUtil.toJsonString(info));
    }
}
