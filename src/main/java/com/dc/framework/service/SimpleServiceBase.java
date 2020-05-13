package com.dc.framework.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dc.framework.lang.reflect.Reflections;
import com.dc.framework.orm.mybatis.MybatisDao;
import com.dc.framework.page.Page;
import com.dc.framework.page.PageContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * 简单服务类，直接使用Ibatis3Dao简化不必要的dao类
 * 
 * @param <E> 实体类
 * @param <ID>实体类的主键类
 */
public abstract class SimpleServiceBase<E, ID extends Serializable> implements
        EntityService<E, ID>, InitializingBean {
    
    protected MybatisDao<E, ID> myBatisDao;
    protected Class<E> entityClass;
    
    public SimpleServiceBase() {

        this.entityClass = Reflections.getSuperClassGenricType(getClass());
    }
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {

        this.myBatisDao = new MybatisDao<E, ID>(sqlSessionFactory, getEntityClass());
    }
    
    public int delete(E... entities) {

        return myBatisDao.delete(entities);
    }
    
    public int deleteById(ID... ids) {

        return myBatisDao.deleteById(ids);
    }
    
    public List<E> findAll() {

        return myBatisDao.findAll();
    }
    
    public List<E> findBy(Map<?, ?> map) {

        return myBatisDao.findBy(map);
    }
    
    public E findById(ID id) {

        return myBatisDao.findById(id);
    }
    
    public Page<E> findPage(PageContext pageContext) {

        return myBatisDao.findPage(pageContext);
    }
    
    public Class<E> getEntityClass() {

        return entityClass;
    }
    
    public int insert(E entity) {

        return myBatisDao.insert(entity);
    }
    
    public int update(E entity) {

        return myBatisDao.update(entity);
    }
    
    public final void afterPropertiesSet() throws Exception {

        Assert.notNull(myBatisDao.getSqlSessionFactory(), "sqlSessionFactory can not be null!");
    }
}
