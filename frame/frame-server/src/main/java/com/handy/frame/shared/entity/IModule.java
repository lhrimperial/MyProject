package com.handy.frame.shared.entity;

import java.util.List;



/**
 * @author longhairen
 * @create 2017/6/6 0006 下午 7:24
 * 模块接口定义
 */
public interface IModule extends IEntity {
	
	List<IFunction>	 getFunctions();

}
