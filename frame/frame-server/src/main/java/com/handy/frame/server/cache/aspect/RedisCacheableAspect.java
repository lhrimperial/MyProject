package com.handy.frame.server.cache.aspect;

import com.handy.frame.server.cache.annotation.RedisCacheKey;
import com.handy.frame.server.cache.annotation.RedisCacheable;
import com.handy.frame.server.database.redis.RedisClient;
import com.handy.frame.util.FastJsonUtil;
import com.handy.frame.util.ReflectionUtils;
import com.handy.frame.util.StringUtils;
import com.handy.frame.util.ValidateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author： longhairen
 * @Date：2016年7月11日 下午3:53:15
 * @Description：拦截@RedisCacheable注解
 */
@Aspect
public class RedisCacheableAspect {

    private Logger logger = Logger.getLogger(RedisCacheableAspect.class.getName());

    @Autowired
    private RedisClient redisClient;

    @Around("@annotation(redisCache)")
    public Object cached(final ProceedingJoinPoint pjp, RedisCacheable redisCache) throws Throwable {
        try {
            String key = getCacheKey(pjp, redisCache);
            String returnType = getReturnType(pjp);
            Object value = redisClient.get(key);    //从缓存获取数据
            if (value != null) {
                Object result = value;
                try {
                    result = FastJsonUtil.json2Bean((String) value, Class.forName(returnType));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return result;
            }

            value = pjp.proceed();      //跳过缓存,到后端查询数据

            if (value == null) {
                return value;
            }

            if (redisCache.expire() <= 0) {      //如果没有设置过期时间,则默认缓存24小时
                redisClient.set(key, FastJsonUtil.toJsonString(value));
            } else {                    //否则设置缓存时间
                redisClient.set(key, FastJsonUtil.toJsonString(value), redisCache.expire());
            }
            return value;
        } catch (Exception e) {
            logger.info("Redis缓存存取异常：" + e.getMessage());
            return pjp.proceed();
        }
    }

    /**
     * 获取返回类型
     *
     * @param pjp
     * @return
     */
    private String getReturnType(ProceedingJoinPoint pjp) {
        try {
            Signature sig = pjp.getSignature();
            if (!(sig instanceof MethodSignature)) {
                throw new IllegalArgumentException("该注解只能用于方法");
            }
            MethodSignature msig = (MethodSignature) sig;
            Object target = pjp.getTarget();
            Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
            return currentMethod.getReturnType().getName();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获取缓存的key值
     *
     * @param pjp
     * @param redisCache
     * @return
     */
    private String getCacheKey(ProceedingJoinPoint pjp, RedisCacheable redisCache) {

        StringBuilder buf = new StringBuilder();
        buf.append(pjp.getSignature().getDeclaringTypeName()).append(".").append(pjp.getSignature().getName());
        String keyStr = redisCache.key();
        if (StringUtils.isNotBlank(keyStr)) {
            buf.append(".").append(keyStr);
        }
        //参数
        Object[] args = pjp.getArgs();

        if (redisCache.keyMode() == RedisCacheable.KeyMode.DEFAULT){
            if (args.length > 0){
                for (int i = 0, len = args.length; i < len; i++){
                    if(args[i] instanceof String) {
                        buf.append("#").append(args[i].toString());
                    }
                }
            }
        } else if (redisCache.keyMode() == RedisCacheable.KeyMode.ANNO) {
            Annotation[][] pas = ((MethodSignature) pjp.getSignature()).getMethod().getParameterAnnotations();
            firstLoop:
            for (int i = 0, len = pas.length; i < len; i++) {
                for (int j = 0, len0 = pas[i].length; j < len0; j++) {
                    if (RedisCacheKey.class.isInstance(pas[i][j])) {
                        Object obj = args[i];
                        if (obj instanceof String) {
                            buf.append("#").append(obj);
                        } else if (obj instanceof Integer) {
                            buf.append("#").append(obj.toString());
                        } else if (obj instanceof Long) {
                            buf.append("#").append(obj.toString());
                        } else if (obj instanceof Short) {
                            buf.append("#").append(obj.toString());
                        } else if (obj instanceof Boolean) {
                            buf.append("#").append(obj.toString());
                        }
                        break firstLoop;
                    }
                }
            }
        } else if ((redisCache.keyMode() == RedisCacheable.KeyMode.BEAN)) {
            for (int i = 0, len = args.length; i < len; i++) {
                Field[] fields = args[i].getClass().getFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(RedisCacheKey.class)) {
                        Object value = ReflectionUtils.getField(field, args[i]);
                        buf.append("#").append(value.toString());
                    }
                }
            }
        } else if (redisCache.keyMode() == RedisCacheable.KeyMode.MAP) {
            if (keyStr.length() > 0) {
                Map target = (Map) args[0];
                buf.append("#").append(target.get(keyStr));
            }
        } else if (redisCache.keyMode() == RedisCacheable.KeyMode.BASIC) {

        }

        return buf.toString();
    }
}