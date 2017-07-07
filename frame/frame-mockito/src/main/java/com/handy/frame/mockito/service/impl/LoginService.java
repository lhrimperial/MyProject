package com.handy.frame.mockito.service.impl;

import com.handy.frame.mockito.domain.Person;
import com.handy.frame.mockito.service.IDubboInterfaceService;
import com.handy.frame.mockito.service.ILoginService;
import com.handy.frame.util.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longhairen
 * @create 2017/7/4 0004 下午 4:09
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private IDubboInterfaceService dubboInterfaceService;

    @Override
    public void login(Person person) {
        Person exstPerson = dubboInterfaceService.findPerson(person.getUserName());
        if (exstPerson == null){
            throw new RuntimeException("person not exist");
        }else if (!person.getPassword().equals(exstPerson.getPassword())){
            throw new RuntimeException("password is error ");
        }
        System.out.println(FastJsonUtil.toJsonString(exstPerson));
    }
}
