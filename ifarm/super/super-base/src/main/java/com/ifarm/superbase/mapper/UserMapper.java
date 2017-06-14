package com.ifarm.superbase.mapper;

import com.ifarm.superback.domain.po.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 3:16
 */
@Repository
public interface UserMapper {


    /**
     * 根据用户编码查询用户信息
     * @param userCode
     * @return
     */
    UserDO findUserByUserCode(String userCode);

    /**
     * 保存用户信息
     * @param userDO
     */
    void insert(UserDO userDO);

    /**
     * 更新用户信息
     * @param userDO
     */
    void update(UserDO userDO);
}
