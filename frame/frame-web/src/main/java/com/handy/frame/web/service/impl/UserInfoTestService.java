package com.handy.frame.web.service.impl;

import com.handy.frame.server.cache.annotation.RedisCacheKey;
import com.handy.frame.server.cache.annotation.RedisCacheable;
import com.handy.frame.web.domain.UserInfo;
import com.handy.frame.web.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longhairen
 * @create 2017/6/8 0008 上午 11:42
 */
@Service
public class UserInfoTestService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RedisCacheable(expire=300,keyMode=RedisCacheable.KeyMode.BEAN,key="logid")
    public UserInfo findUserInfo(UserInfo param) {
        return userInfoMapper.findUserInfo(param);
    }

    @RedisCacheable(expire=300,keyMode=RedisCacheable.KeyMode.DEFAULT,key="logid")
    public Integer getNumber(@RedisCacheKey String name, String age){
        return 12345678;
    }
}
