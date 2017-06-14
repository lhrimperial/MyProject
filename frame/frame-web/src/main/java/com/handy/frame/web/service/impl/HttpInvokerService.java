package com.handy.frame.web.service.impl;

import com.handy.frame.web.domain.UserInfo;
import com.handy.frame.web.mapper.UserInfoMapper;
import com.handy.frame.web.service.IHttpInvokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author longhairen
 * @create 2017/6/14 0014 下午 4:48
 */
@Component("httpInvokerService")
public class HttpInvokerService implements IHttpInvokerService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findUserById(int id) {
        UserInfo info = new UserInfo();
        info.setId(1);
        return userInfoMapper.findUserInfo(info);
    }
}
