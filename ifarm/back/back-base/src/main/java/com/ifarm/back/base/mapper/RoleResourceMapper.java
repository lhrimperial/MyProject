package com.ifarm.back.base.mapper;

import com.ifarm.back.base.domain.po.RoleResourcePO;
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
    RoleResourcePO findRoleResByRoleCode(String roleCode);

    /**
     *
     * @param roleResourcePO
     */
    void insert(RoleResourcePO roleResourcePO);

    /**
     *
     * @param roleResourcePO
     */
    void update(RoleResourcePO roleResourcePO);
}
