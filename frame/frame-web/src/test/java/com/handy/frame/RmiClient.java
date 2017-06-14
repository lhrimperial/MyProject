package com.handy.frame;

import com.handy.frame.web.service.IRmiService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.rmi.Naming;

/**
 * @author longhairen
 * @create 2017/6/14 0014 下午 3:48
 */
@Component
@ContextConfiguration("classpath:*spring-rmiclient.xml")
public class RmiClient extends AbstractJUnit4SpringContextTests{

    @Autowired
    @Qualifier("clentrmi")
    private IRmiService clentrmi;

    @Test
    public void test(){
        System.out.println(clentrmi.sayHi("andy"));
    }

    public static void main(String[] args) throws Exception{
        String url = "192.168.2.159:1021/serverRmi";
        IRmiService rmiService = (IRmiService) Naming.lookup("rmi://"+url);
        System.out.println(rmiService.sayHi("hello"));

    }
}
