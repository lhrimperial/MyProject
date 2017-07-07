package com.handy.frame.activemq;

import com.handy.frame.web.domain.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author longhairen
 * @create 2017/6/21 0021 下午 1:36
 */
@ContextConfiguration("classpath:*spring.xml")
public class ProducerTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    @Qualifier("textProcerService")
    private ProducerService producerService;

    @Autowired
    @Qualifier("objectProcerSrevice")
    private ProducerService objectProcerSrevice;

    @Test
    public void test1(){
        UserInfo user = new UserInfo();
        user.setUserName("andy");
        user.setEmail("lhr9563215@163.com");
        user.setMobileNo("18621526765");
        objectProcerSrevice.sendMessage(user);
    }

    @Test
    public void test(){
        producerService.sendMessage("Hello Consumer!");
    }
}
