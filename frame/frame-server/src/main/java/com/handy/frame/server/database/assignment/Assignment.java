package com.handy.frame.server.database.assignment;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author：lognhairen
 * @create：2016年3月30日 下午6:24:13
 * @description：
 */
@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD}) 
public @interface Assignment {
	
}
