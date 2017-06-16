package com.ifarm.back.base.service.impl;

import com.handy.frame.util.ReflectionUtils;
import com.ifarm.back.base.domain.bo.UserBO;
import com.ifarm.back.base.domain.po.UserDO;
import com.ifarm.back.base.mapper.UserMapper;
import com.ifarm.back.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longhairen
 * @create 2017/6/15 0015 上午 9:29
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBO findUserByCode(String userCode) {
        UserDO userDO = userMapper.findUserByUserCode(userCode);
        UserBO userBO = new UserBO();
        ReflectionUtils.copyProperties(userDO, userBO);
        return userBO;
    }
}
