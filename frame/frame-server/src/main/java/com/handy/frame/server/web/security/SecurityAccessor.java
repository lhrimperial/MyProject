package com.handy.frame.server.web.security;


import com.handy.frame.server.cache.CacheManager;
import com.handy.frame.server.cache.ICache;
import com.handy.frame.server.context.RequestContext;
import com.handy.frame.server.context.UserContext;
import com.handy.frame.server.web.security.exception.AccessNotAllowException;
import com.handy.frame.server.web.security.exception.UserNotLoginException;
import com.handy.frame.shared.entity.IFunction;
import com.handy.frame.shared.entity.IUser;

import java.util.Set;


/**
* @ClassName: SecurityAccessor
* @Description: 权限访问控制器
* @author longhairen
* @date 2017年4月22日 下午2:45:33
*
*/
public final class SecurityAccessor {
    
    private SecurityAccessor() {
	}

	/**
     * 读取request头里的method，并判断与实际调用method是否一致，不一致抛出异常
     * checkMethodAccessSecurity
     * @param methodName
     * @return void
     * @since:0.6
     */
    public static void checkMethodAccessSecurity(String methodName) {
        final String protocolHeader = RequestContext.getCurrentContext().getRemoteRequestMethod();
        if (null == protocolHeader) {
        	return;
        }
        if (!protocolHeader.equalsIgnoreCase(methodName)) {
            // Client forge method invoke url
            throw new AccessNotAllowException();
        }
    }
    
    /**
     * 校验权限
     * checkURLAccessSecurity
     * @param accessURL
     * @return void
     * @since:0.6
     */
	public static void checkURLAccessSecurity(String accessURL) {
		checkURLAccessSecurity(accessURL, true);
    }
	
    /**
     * 校验权限
     * checkURLAccessSecurity
     * @param accessURL
     * @return void
     * @since:0.6
     */
	public static void checkURLAccessSecurity(String accessURL, boolean ignoreUnstoredFunction) {
        
        IUser user = UserContext.getCurrentUser();
        //用户未登录
        if (user == null) {
            throw new UserNotLoginException();
        }
        
        // 去掉多余的'/'
        if (accessURL != null) {
        	accessURL = accessURL.replaceAll("[/]{2,}", "/");
        }
        IFunction function = getFunction(accessURL);
        if (function == null) {
        	if (ignoreUnstoredFunction) {
        		return;
        	}
        	
        	throw new AccessNotAllowException(accessURL); 
        }
        
        if(!function.getValidFlag()){
        	return;
        }
        Set<String> accessUris = user.queryAccessUris();
        
        // 是否拥有访问权限
        if (accessUris==null || !accessUris.contains(function.getUri())) {
        	throw new AccessNotAllowException();
        }
    }
	
	@SuppressWarnings("unchecked")
    public static IFunction getFunction(String accessURL) {
        ICache<String,IFunction> functionCache = CacheManager.getInstance().getCache(IFunction.class.getName());
        IFunction function = functionCache.get(accessURL);
        return function;
    }
    
    /**
     * 判断请求是否被允许
     * hasAccessSecurity
     * @param accessURL
     * @return
     * @return boolean
     * @since:0.7
     */
    public static boolean hasAccessSecurity(String accessURL) {
        try {
        	checkURLAccessSecurity(accessURL);
        	return true;
        } catch (Exception t) {
        	return false;
        }
    }
    
}
