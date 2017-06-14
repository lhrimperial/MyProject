package com.handy.frame.web.service.impl;

import com.handy.frame.web.service.IRmiService;
import org.springframework.stereotype.Component;

/**
 * @author longhairen
 * @create 2017/6/14 0014 下午 3:42
 */
@Component("rmiService")
public class RmiServiceImpl implements IRmiService {
    @Override
    public String sayHi(String name) {
        return "Hi,"+name;
    }
}
