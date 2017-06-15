package com.ifarm.back.base.mapper;


import com.ifarm.back.base.domain.po.EmployeeDO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/14 0014 上午 10:09
 */
@Repository
public interface EmployeeMapper {

    /**
     *
     * @param empCode
     * @return
     */
    EmployeeDO findEmpByCode(String empCode);

    /**
     *
     * @param employeeDO
     */
    void update(EmployeeDO employeeDO);

    /**
     *
     * @param employeeDO
     */
    void insert(EmployeeDO employeeDO);
}
