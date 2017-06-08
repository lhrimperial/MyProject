package com.handy.frame.web.mapper;

import com.handy.frame.web.domain.UserInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by longhairen on 2017/4/20 0020.
 */
@Repository
public interface UserInfoMapper {

    public void saveUserInfo(UserInfo userInfo);

    public void saveBatchUserInfo(List<UserInfo> userInfos);

    public void updateUserInfo(UserInfo userInfo);

    public UserInfo findUserInfo(UserInfo param);

    public List<UserInfo> queryUserInfoList(UserInfo userInfo, RowBounds rowBounds);

    public List<UserInfo> queryList(Map<String, Object> param);

    public void deleteUserInfo(UserInfo parem);
}
