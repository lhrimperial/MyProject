package com.handy.frame.server.web.security;

import java.lang.annotation.*;


/**
* @ClassName: SecurityNonCheckRequired
* @Description: 权限控制注解，使用该注解表明无需判断权限
* @author longhairen
* @date 2017年4月22日 下午2:45:54
*
*/
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SecurityNonCheckRequired {
    
}
