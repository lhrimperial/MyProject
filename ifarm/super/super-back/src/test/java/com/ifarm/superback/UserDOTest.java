package com.ifarm.superback;

import com.handy.frame.shared.constant.Logical;
import com.handy.frame.util.FastJsonUtil;
import com.handy.frame.util.cryp.MD5Util;
import com.ifarm.superback.domain.UserDO;
import com.ifarm.superback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import org.junit.Test;
/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 3:56
 */


@Component
@ContextConfiguration("classpath:spring.xml")
public class UserDOTest extends AbstractJUnit4SpringContextTests{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        UserDO userDO = userMapper.findUserByUserCode("275688");
        System.out.println(FastJsonUtil.toJsonString(userDO));
    }

    @Test
    public void test(){
        UserDO userDO = new UserDO();
        userDO.setUserCode("275688");
        userDO.setPassWord(MD5Util.md5Encrypt("123456"));
        userDO.setEmpCode("275688");
        userDO.setEmpName("龙海仁");
        userDO.setIsEmp(Logical.IS.value());
        userDO.setIsDeleted(Logical.NOT.value());
        userDO.setOrgCode("DP0001");
        userMapper.insert(userDO);
}

    public static void main(String[] args){
        System.out.println(Logical.IS);
    }
}
