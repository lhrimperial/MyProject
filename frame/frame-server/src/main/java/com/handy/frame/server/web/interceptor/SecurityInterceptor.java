package com.handy.frame.server.web.interceptor;

import com.handy.frame.server.context.RequestContext;
import com.handy.frame.server.web.security.SecurityAccessor;
import com.handy.frame.server.web.security.SecurityNonCheckRequired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author longhairen
 * @create 2017/6/9 0009 上午 9:37
 * 权限控制拦截器
 */
public class SecurityInterceptor implements HandlerInterceptor {

    /** 是否忽略检查权限表里没有映射的URL */
    private boolean ignoreUnstoredFunction = true;

    /**
     * 权限控制拦截器主方法，实现权限控制
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method =handlerMethod.getMethod();
        final String url = RequestContext.getCurrentContext().getRemoteRequestURL();
        if (!method.isAnnotationPresent(SecurityNonCheckRequired.class)) {
            SecurityAccessor.checkURLAccessSecurity(url, this.ignoreUnstoredFunction);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
