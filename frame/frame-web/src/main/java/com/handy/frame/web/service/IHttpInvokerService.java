package com.handy.frame.web.service;

import com.handy.frame.web.domain.UserInfo;

/**
 * @author longhairen
 * @create 2017/6/14 0014 下午 4:46
 */
public interface IHttpInvokerService {

    UserInfo findUserById(int id);
}
