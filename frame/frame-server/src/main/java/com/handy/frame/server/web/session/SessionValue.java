package com.handy.frame.server.web.session;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
* @ClassName: SessionValue
* @Description: 标注允许被放入session的类型
* @author longhairen
* @date 2017年4月22日 下午3:01:06
*
*/
@Target(TYPE)
@Retention(RUNTIME)
public @interface SessionValue {
    
}
