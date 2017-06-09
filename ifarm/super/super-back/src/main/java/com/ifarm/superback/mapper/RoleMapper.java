package com.ifarm.superback.mapper;

import com.ifarm.superback.domain.RoleDO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 5:08
 */
@Repository
public interface RoleMapper {

    /**
     *
     * @param roleCode
     * @return
     */
    RoleDO findRoleByRoleCode(String roleCode);

    /**
     *
     * @param roleDO
     */
    void insert(RoleDO roleDO);

    /**
     *
     * @param roleDO
     */
    void update(RoleDO roleDO);
}
