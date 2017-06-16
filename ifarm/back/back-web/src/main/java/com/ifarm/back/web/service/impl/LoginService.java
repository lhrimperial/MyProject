package com.ifarm.back.web.service.impl;

import com.handy.frame.util.FastJsonUtil;
import com.ifarm.back.base.domain.bo.UserBO;
import com.ifarm.back.base.service.IUserService;
import com.ifarm.back.web.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 3:36
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private IUserService userService;

    @Override
    public void userLogin(String userName, String password) {

    }

    @Override
    public UserBO findUserByCode(String userName) {
        UserBO userBO = userService.findUserByCode(userName);
        System.out.println(FastJsonUtil.toJsonString(userBO));
        return userBO;
    }
}
