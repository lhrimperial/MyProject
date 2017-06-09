package com.ifarm.superback.mapper;

import com.ifarm.superback.domain.RoleResourceDO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 5:32
 */
@Repository
public interface RoleResourceMapper {

    /**
     *
     * @param roleCode
     * @return
     */
    RoleResourceDO findRoleResByRoleCode(String roleCode);

    /**
     *
     * @param roleResourceDO
     */
    void insert(RoleResourceDO roleResourceDO);

    /**
     *
     * @param roleResourceDO
     */
    void update(RoleResourceDO roleResourceDO);
}
