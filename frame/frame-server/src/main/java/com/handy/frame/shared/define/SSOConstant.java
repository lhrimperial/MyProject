package com.handy.frame.shared.define;


/**
 * SSO模块相关的常量
 * @author longhairen
 * @date 2017年6月23日
 */
public interface SSOConstant {
	/**
	 * 和当前应用ID相关
	 */
	final String CUR_APP_ID = "_CUR_APP_ID";
	/**
	 * 令牌Parameter
	 */
	final String TOKEN_NAME = "_TOKEN";
	/**
	 * 源APP
	 */
	final String SOURCE_APP_ID = "_SOURCE_APP_ID";

	/**
	 * session中保存的用户ID的name
	 */
	final String LOGON_USER = "FRAMEWORK__KEY_USER__";

	/**
	 * 校验结果
	 */
	final String VALIDATE_RESULT = "VALIDATE_RESULT";

	/**
	 * web.xml--CONTEXT-PARAM 参数名
	 */
	final String CTX_PM_SSO_APP_ID = "ssoCurrentApp";

	/**
	 * 已登录用户的ID名称
	 */
	final String LOGED_IN_USER_ID = "LOGED_IN_USER_ID";
	/**
	 * 数据源名称
	 */
	final String DATASOURCE_NAME="DATASOURCE_NAME";
	/**
	 * 数据库schema
	 */
	final String DATABASE_SCHEMA="DATABASE_SCHEMA";
	/**
	 * 集中缓存服务器信息
	 */
	final String MEM_SERVER="MemeryCacheServer";
	
	/**
	 * cookie中的session key
	 */
	final String JSESSIONID = "JSESSIONID";
}
