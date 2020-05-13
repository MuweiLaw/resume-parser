package com.dc.framework.spring.datasource;

/**
 * @author wx
 * @version v1.0.0
 * @className DataSourceHolder1
 * @description TODO
 * @date 2019/12/25 11:52
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> dsHolder = new ThreadLocal<String>();

    /**
     * 切换数据源
     *
     * @param keyName 必须是在Spring已定义的数据源的Bean Name
     */
    public static void switchDataSource(String keyName) {

        dsHolder.set(keyName);
    }

    /**
     * 返回当前使用的数据源的Bean Name，DynamicSwitchDataSource会根据此Name 去查找已注册的DataSource
     *
     * @return
     */
    public static String currentDataSource() {

        return dsHolder.get();
    }

    public static void removeCurrent() {

        dsHolder.remove();
    }
}
