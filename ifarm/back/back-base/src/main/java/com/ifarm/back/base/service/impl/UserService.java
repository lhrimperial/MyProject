package com.ifarm.back.base.service.impl;

import com.ifarm.back.base.domain.bo.UserBO;
import com.ifarm.back.base.mapper.UserMapper;
import com.ifarm.back.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author longhairen
 * @create 2017/6/15 0015 上午 9:29
 */
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBO findUserByCode(String userCode) {
        return null;
    }
}
