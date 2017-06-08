package com.handy.frame.web.service;


import com.handy.frame.web.domain.UserInfo;

import java.util.List;


/**
 * Created by longhairen on 2017/4/20 0020.
 */
public interface IUserInfoService {

    public void saveUserInfo(UserInfo userInfo);

    public void saveBatchUserInfo(List<UserInfo> userInfos);

    public void updateUserInfo(UserInfo userInfo);

    public UserInfo findUserInfo(UserInfo param);

    public List<UserInfo> findUserInfoList(UserInfo param);

    public void deleteUserInfo(UserInfo parem);
}
