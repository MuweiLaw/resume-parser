package com.dc.framework.dao;

import com.dc.framework.lang.Assert;
import com.dc.framework.orm.mybatis.MybatisDao;
import com.dc.framework.page.PageContext;
import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author wx
 * @version 1.0.0
 * @className MybatisDaoSupport
 * @description 基于Mybatis的crud dao基类。
 * @date 2019/12/13 21:04
 */
public class MybatisDaoSupport<E, ID extends Serializable> extends MybatisDao<E, ID> implements
        EntityDao<E, ID>, InitializingBean {

    @Override
    public List<E> findBy(PageContext fp) {
        throw new UnsupportedOperationException();
    }

    public final void afterPropertiesSet() throws Exception {
        checkDaoConfig();
    }

    protected void checkDaoConfig() throws IllegalArgumentException {
        Assert.notNull(sqlSessionFactory, "sqlSessionFactory can not be null!");
    }
}
