package com.ifarm.back.web.service;

import com.ifarm.back.base.domain.bo.UserBO;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 3:35
 */
public interface ILoginService {

    void userLogin(String userName, String password);

    UserBO findUserByCode(String userName);
}
