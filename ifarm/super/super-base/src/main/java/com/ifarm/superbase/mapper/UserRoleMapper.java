package com.ifarm.superbase.mapper;


import com.ifarm.superbase.domain.po.UserRoleDO;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 5:24
 */
@Repository
public interface UserRoleMapper {

    /**
     *
     * @param userCode
     * @return
     */
    UserRoleDO findUserRoleByUserCode(String userCode);

    /**
     *
     * @param userRoleDO
     */
    void insert(UserRoleDO userRoleDO);

    /**
     *
     * @param userRoleDO
     */
    void update(UserRoleDO userRoleDO);
}