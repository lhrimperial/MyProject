package com.ifarm.back.base.service;

import com.ifarm.back.base.domain.bo.UserBO;

/**
 * @author longhairen
 * @create 2017/6/15 0015 上午 9:28
 */
public interface IUserService {

    UserBO findUserByCode(String userCode);
}
