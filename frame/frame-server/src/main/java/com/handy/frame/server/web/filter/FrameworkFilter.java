package com.handy.frame.server.web.filter;

import com.handy.frame.server.cache.CacheManager;
import com.handy.frame.server.cache.ICache;
import com.handy.frame.server.context.AppContext;
import com.handy.frame.server.context.RequestContext;
import com.handy.frame.server.context.SessionContext;
import com.handy.frame.server.context.UserContext;
import com.handy.frame.server.web.session.ISession;
import com.handy.frame.server.web.xss.ParametersValidator;
import com.handy.frame.server.web.xss.ParametersValidatorException;
import com.handy.frame.server.web.xss.XssConfigContext;
import com.handy.frame.shared.define.Definitions;
import com.handy.frame.shared.define.LocaleConst;
import com.handy.frame.shared.define.Protocol;
import com.handy.frame.shared.entity.IUser;
import com.handy.frame.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @ClassName: FrameworkFilter
 * @Description: 框架过滤器
 * @author longhairen
 * @date 2017年4月22日 下午2:53:30
 * 
 */
public class FrameworkFilter extends DefaultFilter {

	private static ServletContext servletContext;

	public static ServletContext getServletContext() {
		return servletContext;
	}

	/**
	 * 初始化Filter
	 * @param config
	 * @throws ServletException
	 * @since:0.6
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		getServletContext(config);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(XssConfigContext.EXPRESSION,
				config.getInitParameter(XssConfigContext.EXPRESSION));
		map.put(XssConfigContext.TACTICS,
				config.getInitParameter(XssConfigContext.TACTICS));
		map.put(XssConfigContext.PATH,
				config.getInitParameter(XssConfigContext.PATH));
		AppContext.setParametersValidator(new ParametersValidator(
				new XssConfigContext(map)));
	}

	public static void getServletContext(FilterConfig config) {
		servletContext = config.getServletContext();
	}

	/**
	 * 设置应用信息
	 *
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 * @since:0.6
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		/** 取得HttpServletRequest,这里可以拿到HttpSession **/
		HttpServletRequest sreq = null;
		if (request instanceof HttpServletRequest) {
			sreq = (HttpServletRequest) request;
			// 过滤参数
			try {
				AppContext.getParametersValidator().doValidator(sreq,
						(HttpServletResponse) response);
			} catch (ParametersValidatorException e) {
				return;
			}
			/** 寻找客户端是否采用Hessian协议,HTTP头部有此定义 **/
			String remoteReqMethod = sreq.getHeader(Protocol.SECURITY_HEADER);
			String remoteReqURL = sreq.getRequestURI();
			String contextPath = sreq.getContextPath();
			/** 去掉应用名称，具体部署的应用名称是可变的 **/
			if (contextPath != null && !"/".equals(contextPath)
					&& remoteReqURL.startsWith(contextPath)) {
				remoteReqURL = remoteReqURL.substring(contextPath.length());
			}
			/** 将当前访问的路径和远程头信息放入权限上下文 **/
			RequestContext.setCurrentContext(remoteReqMethod, remoteReqURL,
					request.getRemoteAddr());

			/** 会话保留到SessionContext，以便各层使用 **/
			SessionContext.setSession(sreq.getSession(true));

			ISession session = SessionContext.getSession();
			// set locale to usercontext
			Locale locale = (Locale) session.getObject(Definitions.KEY_LOCALE);
			// get request locale
			if (locale == null) {
				locale = sreq.getLocale();
				session.setObject(Definitions.KEY_LOCALE, locale);
			}

			String localeLanguage = sreq
					.getParameter(LocaleConst.KEY_LOCALE_LANGUAGE);
			String localeCountry = sreq
					.getParameter(LocaleConst.KEY_LOCALE_COUNTRY);
			if (localeLanguage != null && localeCountry != null) {
				locale = new Locale(localeLanguage, localeCountry);
				session.setObject(Definitions.KEY_LOCALE, locale);
			}

			UserContext.setUserLocale(locale);

			// set user to usercontext
			// 先从session中取值
			String userId = (String) session.getObject(Definitions.KEY_USER);

			if (StringUtils.isBlank(userId)) {
				// 如果session中没有值，再从reqeust的header中取值，这个方案是给gui一类的另外途径调用方法的时候使用
				userId = sreq.getHeader(Definitions.KEY_USER);
			}

			if (StringUtils.isNotBlank(userId)) {
				ICache<String, IUser> userCache = CacheManager.getInstance()
						.getCache(IUser.class.getName());
				UserContext.setCurrentUser(userCache.get(userId));
			}
		}

		try {
			super.doFilter(request, response, filterChain);
		} finally {
			// 清除ThreadLocal中持有的信息
			SessionContext.remove();
			RequestContext.remove();
			UserContext.remove();
		}

	}

}
