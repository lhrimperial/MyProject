package com.handy.frame.shared.entity;

import java.util.Set;


/**
 * @author longhairen
 * @create 2017/6/6 0006 下午 7:24
 * 用户接口定义
 */
public interface IUser extends IEntity {

	/**
	 * 获取用户的所有角色id getRoleids
	 * 
	 * @return
	 * @return Set<String>
	 * @since:0.9
	 */
	Set<String> getRoleids();

	Set<String> queryAccessUris();

	void setRoleids(Set<String> paramSet);

	void setUserName(String paramString);

	String getUserName();
}
