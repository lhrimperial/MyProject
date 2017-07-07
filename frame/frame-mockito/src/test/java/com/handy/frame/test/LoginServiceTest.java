package com.handy.frame.test;

import com.handy.frame.mockito.domain.Person;
import com.handy.frame.mockito.service.IDubboInterfaceService;
import com.handy.frame.mockito.service.ILoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author longhairen
 * @create 2017/7/4 0004 下午 4:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-config.xml")
public class LoginServiceTest {

    //@InjectMocks 标签会自动填充带@Mock标签的bean
    @Autowired
    @InjectMocks
    private ILoginService loginService;

    //@Mock 相当于mockito帮助简单的实例化bean，因此无法执行原生方法。
    @Mock
    private IDubboInterfaceService dubboInterfaceService;

    @Before
    public void initMock(){
        //初始化mock引擎
        MockitoAnnotations.initMocks(this);
        //构造需要返回的数据
        Person person = new Person();
        person.setPassword("12345");
        person.setUserName("andy");
        //指定mock对象方法返回
        when(dubboInterfaceService.findPerson(anyString())).thenReturn(person);
    }

    @Test
    public void test(){
        Person p = new Person("andy", "12345");
        loginService.login(p);

    }
}
