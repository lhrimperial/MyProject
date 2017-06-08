package com.handy.frame.server.database.rwseparation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author：龙海仁
 * @create：2016年11月23日 上午10:24:49
 * @description：只读数据源连接切面
 */
@Aspect
public class ReadOnlyConnectionAspect {
	
	@Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint pjp, ReadOnlyConnection readOnlyConnection) throws Throwable {
        try {
        	DataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE);
            Object result = pjp.proceed();
            return result;
        } finally {
        	DataSourceContextHolder.clearDataSourceType();
        }
    }
}
