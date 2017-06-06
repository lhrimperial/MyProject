package com.handy.frame.shared.entity;

import java.util.Collection;


/**
 * @author longhairen
 * @create 2017/6/6 0006 下午 7:24
 * 角色接口定义
 */

public interface IRole  extends IEntity{
	
	Collection<String> getFunctionIds();

}
