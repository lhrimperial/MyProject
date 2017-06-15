package com.ifarm.back.base.mapper;


import com.ifarm.back.base.domain.po.UserRoleDO;
import org.springframework.stereotype.Repository;

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
