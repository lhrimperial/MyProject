package com.handy.frame.web.service.impl;

import com.handy.frame.server.cache.annotation.RedisCacheable;
import com.handy.frame.web.domain.UserInfo;
import com.handy.frame.web.mapper.UserInfoMapper;
import com.handy.frame.web.service.IUserInfoService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by longhairen on 2017/4/20 0020.
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    @Transactional
    public void saveUserInfo(UserInfo userInfo) {
        userInfoMapper.saveUserInfo(userInfo);
    }

    @Override
    @Transactional
    public void saveBatchUserInfo(List<UserInfo> userInfos) {
        userInfoMapper.saveBatchUserInfo(userInfos);
    }

    @Override
    @Transactional
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    @RedisCacheable(expire=300,keyMode=RedisCacheable.KeyMode.BEAN,key="logid")
    public UserInfo findUserInfo(UserInfo param) {
        return userInfoMapper.findUserInfo(param);
    }

    @Override
    public List<UserInfo> findUserInfoList(UserInfo param) {
        RowBounds row = new RowBounds(0, 15);
        return userInfoMapper.queryUserInfoList(param, row);
    }

    @Override
    @Transactional
    public void deleteUserInfo(UserInfo parem) {
        userInfoMapper.deleteUserInfo(parem);
    }
}
