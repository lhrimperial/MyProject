package com.ifarm.superbase.mapper;


import com.ifarm.superbase.domain.po.DepartmentDO;

/**
 * @author longhairen
 * @create 2017/6/14 0014 上午 10:03
 */
@Repository
public interface DepartmentMapper {

    /**
     *
     * @param deptCode
     * @return
     */
    DepartmentDO findDeptByCode(String deptCode);
    /**
     *
     * @param departmentDO
     */
    void update(DepartmentDO departmentDO);

    /**
     *
     * @param departmentDO
     */
    void insert(DepartmentDO departmentDO);
}
