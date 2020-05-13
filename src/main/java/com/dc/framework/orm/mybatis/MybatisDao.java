package com.dc.framework.orm.mybatis;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dc.framework.lang.collection.Lists;
import com.dc.framework.lang.reflect.ClassWrapper;
import com.dc.framework.lang.reflect.Reflections;
import com.dc.framework.orm.id.IdHelper;
import com.dc.framework.orm.mybatis.plugin.OffsetLimitInterceptor;
import com.dc.framework.page.Page;
import com.dc.framework.page.PageContext;
import com.dc.framework.page.Paginations;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author wx
 * @version v1.0.0
 * @className WebMvcConfigurer
 * @description 数据访问类
 * @date 2019/12/14 20:51
 * @param <E>操作的实体类型
 * @param <ID>实体ID类型
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class MybatisDao<E, ID> implements ApplicationContextAware {
    protected SqlSessionTemplate sqlSessionTemplate;
    protected SqlSessionFactory sqlSessionFactory;
    protected Class<E> entityClass;

    public MybatisDao() {
        this.entityClass = Reflections.getSuperClassGenricType(getClass());
    }

    public MybatisDao(final SqlSessionFactory sqlSessionFactory, final Class<E> entityClass) {
        setSqlSessionFactory(sqlSessionFactory);
        this.entityClass = entityClass;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.sqlSessionFactory = applicationContext.getBean(SqlSessionFactory.class);
        this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public SqlSessionFactory getSqlSessionFactory() {

        return sqlSessionFactory;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    /**
     * 实体新增，会检测实体中是否有注解了@ID的Field有的话就会为根据设置注入ID值
     *
     * @param entity
     */
    public int insert(E entity) {
        IdHelper.setId(entity);
        return getSqlSessionTemplate().insert(sql(INSERT), entity);
    }

    public int update(E entity) {

        return getSqlSessionTemplate().update(sql(UPDATE), entity);
    }

    public int delete(E... entities) {

        int i = 0;
        for (E entity : entities) {
            getSqlSessionTemplate().delete(sql(DELETE), entity);
            i++;
        }
        return i;
    }

    public int deleteById(ID... ids) {

        int i = 0;
        for (ID id : ids) {
            getSqlSessionTemplate().delete(sql(DELETE_BY_ID), id);
            i++;
        }
        return i;
    }

    @SuppressWarnings("unchecked")
    public E findById(ID id) {

        return (E) getSqlSessionTemplate().selectOne(sql(FIND_BY_ID), id);
    }

    @SuppressWarnings("unchecked")
    public List<E> findBy(Map<?, ?> parameter) {

        return getSqlSessionTemplate().selectList(sql(FIND_BY_MAP), parameter);
    }

    @SuppressWarnings("unchecked")
    public List<E> findBy(E entity) {

        return getSqlSessionTemplate().selectList(sql(FIND_BY_ENTITY), entity);
    }

    public Page<E> findPage(PageContext parameter) {

        return pagingQuery(sql(FIND_Page), parameter);
    }

    @SuppressWarnings("unchecked")
    public List<E> findAll() {

        return getSqlSessionTemplate().selectList(sql(FIND_ALL));
    }

    /**
     * 分页查询，必须在Mapper文件定义 Count(*) SQL
     *
     * @param <T>
     * @param countSqlId
     * @param sqlId
     * @param pageContext
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T> Page<T> pagingQuery(String countSqlId, String sqlId, PageContext pageContext) {

        return (Page<T>) pagingQuery(countSqlId, sqlId, pageContext, entityClass);
    }

    @SuppressWarnings("unchecked")
    protected <T> Page<T> pagingQuery(String countSqlId, String findSqlId, PageContext pageContext,
                                      Class<T> entityClass) {

        if (!pageContext.isUsePagination()) {
            List<T> allResult = getSqlSessionTemplate().selectList(findSqlId, pageContext);
            return Paginations.createPage(allResult.size(), null, allResult);
        }
        Long totalCount = (Long) getSqlSessionTemplate().<Object>selectOne(countSqlId, pageContext);
        RowBounds rowBounds = pageContext.getRowBounds();
        if (totalCount == null || totalCount < 1) {
            return Paginations.createPage(0, rowBounds, new ArrayList<T>(0));
        }
        List<T> result = getSqlSessionTemplate().selectList(findSqlId, pageContext, rowBounds);
        return Paginations.createPage(totalCount, rowBounds, result);
    }

    /**
     * 分页查询,执行时会动态生成Count(*) sql
     *
     * @param <T>
     * @param findSqlId
     * @param pageContext
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T> Page<T> pagingQuery(String findSqlId, PageContext pageContext) {

        return (Page<T>) pagingQuery(findSqlId, pageContext, entityClass);
    }

    public <T> Page<T> findPage(String findSqlId, PageContext pageContext, Class<T> entityClass) {

        return pagingQuery(findSqlId, pageContext, entityClass);
    }

    @SuppressWarnings("unchecked")
    protected <T> Page<T> pagingQuery(String findSqlId, PageContext pageContext,
                                      Class<T> entityClass) {

        if (!pageContext.isUsePagination()) {
            List<T> allResult = getSqlSessionTemplate().selectList(findSqlId, pageContext);
            return Paginations.createPage(allResult.size(), null, allResult);
        }
        Long totalCount = dynamicCount(findSqlId, pageContext);
        RowBounds rowBounds = pageContext.getRowBounds();
        if (totalCount == null || totalCount < 1) {
            return Paginations.createPage(0, rowBounds, new ArrayList<T>(0));
        }
        List<T> result = getSqlSessionTemplate().selectList(findSqlId, pageContext, rowBounds);
        return Paginations.createPage(totalCount, rowBounds, result);
    }

    /**
     * 根据指定的查询Sql动态生成count sql
     *
     * @param sqlId
     * @param parameter
     * @return
     */
    public Long dynamicCount(String sqlId, Object parameter) {
        long currentTime = System.currentTimeMillis();
        createCountMappedStatement(sqlId,parameter,currentTime);
        Long count = (Long) getSqlSessionTemplate().selectOne(countMappedId(currentTime), parameter);
        removeCountMappedStatement(currentTime);
        return count;
    }

    public SqlSessionTemplate getSqlSessionTemplate() {

        return sqlSessionTemplate;
    }

    protected String sql(String sqlIdPrefix) {

        return entityClass.getName() + "." + sqlIdPrefix;
    }

    private String countMappedId(long currentTime) {
        return currentTime + "-count";
    }

    @SuppressWarnings("unchecked")
    private void removeCountMappedStatement(long currentTime) {

        Configuration config = sqlSessionFactory.getConfiguration();
        ClassWrapper cw = ClassWrapper.wrap(config);
        Field field = cw.getField("mappedStatements");
        if (field != null) {
            Map<String, MappedStatement> mappedStatements = (Map<String, MappedStatement>) cw.getValue(config, field);
            mappedStatements.remove(countMappedId(currentTime));
        }

    }

    private void createCountMappedStatement(String sqlId,Object parameter,long currentTime) {
        MappedStatement ms = sqlSessionFactory.getConfiguration().getMappedStatement(sqlId);
        BoundSql boundSql = ms.getBoundSql(parameter);
        String countSqlId = countMappedId(currentTime);
        String sql = "select count(*) from ( " + boundSql.getSql().trim()
                + " ) count_table___ ";
        BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, boundSql
                .getParameterMappings(), boundSql.getParameterObject());

        // 创建statement 的 return type，等同于在xml中定义:<select returnType="long"...../>
        ResultMap.Builder countResultBuilder = new ResultMap.Builder(ms.getConfiguration(),
                ms.getId() + "-Inline", Long.class, new ArrayList<ResultMapping>());
        List<ResultMap> resultMaps = Lists.of(countResultBuilder.build());

        // 构建statement
        Builder builder = new Builder(ms.getConfiguration(), countSqlId,
                new OffsetLimitInterceptor.BoundSqlSqlSource(newBoundSql), ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
       // builder.keyProperty(ms.getKeyProperties()[0]);

        // setStatementTimeout()
        builder.timeout(ms.getTimeout());

        // setStatementResultMap()
        builder.parameterMap(ms.getParameterMap());

        // setStatementResultMap()
        builder.resultMaps(resultMaps);
        builder.resultSetType(ms.getResultSetType());

        /*
         * count(*) sql 不需要cache builder.cache(ms.getCache());
         * builder.flushCacheRequired(ms.isFlushCacheRequired());
         * builder.useCache(ms.isUseCache());
         */
        sqlSessionFactory.getConfiguration().addMappedStatement(builder.build());

    }

    public final static String COUNT = "count";
    public final static String INSERT = "insert";
    public final static String UPDATE = "update";
    public final static String DELETE = "delete";
    public final static String DELETE_BY_ID = "deleteById";
    public final static String FIND_Page = "findPage";
    public final static String FIND_ALL = "findAll";
    public final static String FIND_BY_MAP = "findByMap";
    public final static String FIND_BY_ID = "findById";
    public final static String FIND_BY_ENTITY = "findByEntity";
    public final static String FIND_BY_ = "findBy";

}