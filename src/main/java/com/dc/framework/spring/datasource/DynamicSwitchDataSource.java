package com.dc.framework.spring.datasource;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 * @author wx
 * @version v1.0.0
 * @className DataSourceHolder1
 * @description 继承自Spring，实现动态切换数据源
 * <p>
 * 因为Spring默认每个类的实例都是单例的，所以不能直接引入FactoryBean进行重设数据源，这样
 * 并发会导至数据源混乱的情形，从Spring2.0.1后就有AbstractRouteringDataSource可以实现
 * 动态地切换数据源，其实AbstractRouteringDataSource就是使用了Map保存了所有要进行切换的
 * DataSource，不过不确定具体的Key，在此实现中主要使用string来充当key
 * </p>
 * @date 2019/12/25 11:52
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 * */
public class DynamicSwitchDataSource extends AbstractRoutingDataSource implements DataSource {
    
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.currentDataSource();
    }
    
}
