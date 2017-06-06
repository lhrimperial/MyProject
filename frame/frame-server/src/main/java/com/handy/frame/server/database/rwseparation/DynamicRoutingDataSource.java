package com.handy.frame.server.database.rwseparation;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author：龙海仁
 * @create：2016年11月23日 上午9:10:01
 * @description：动态路由数据源
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDataSourceType();
	}

}
