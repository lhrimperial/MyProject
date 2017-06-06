package com.handy.frame.shared.entity;



/**
 * @author longhairen
 * @create 2017/6/6 0006 下午 7:24
 * 功能接口定义
 */
public interface IFunction extends IEntity{

	/**
	 * 
	 * @Title:getUri
	 * @Description:用户功能菜单的href
	 * @param @return
	 * @return String
	 * @throws
	 */
	String getUri();
	/**
	 * 
	 * @Title:getKey
	 * @Description:功能菜单的id
	 * @param @return
	 * @return String
	 * @throws
	 */
	String getKey();
	/**
	 * 
	 * @Title:getFunctionCode
	 * @Description:功能菜单的的代码号：code
	 * @param @return
	 * @return String
	 * @throws
	 */
	String getFunctionCode();
	
	/**
	 * 功能是否被启用
	 * getValidFlag
	 * @return
	 * @return Boolean
	 * @since:0.6
	 */
	Boolean getValidFlag();
	
	String getName();
}
