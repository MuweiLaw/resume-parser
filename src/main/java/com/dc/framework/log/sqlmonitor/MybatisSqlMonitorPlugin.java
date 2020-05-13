package com.dc.framework.log.sqlmonitor;

import com.dc.framework.lang.Lang;
import com.dc.framework.lang.Strings;
import com.dc.framework.log.OperationLog;
import com.dc.framework.log.OperationSql;
import com.dc.framework.log.defaults.DefaultOperationSql;
import com.dc.framework.log.defaults.LogHolder;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;

/**
 * @author wx
 * @version v1.0.0
 * @className MybatisSqlMonitorPlugin
 * @description SQL监视器，实现对象SQL拦截，以便可以将每个操作SQL记入日志中
 * @date 2019/12/15 3:22
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Intercepts( {
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class,
                Object.class }),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class,
                Object.class, RowBounds.class, ResultHandler.class }) })
public class MybatisSqlMonitorPlugin implements Interceptor {


    static int MAPPED_STATEMENT_INDEX = 0;
    static int PARAMETER_INDEX = 1;

    private static final Logger logger = LoggerFactory.getLogger(MybatisSqlMonitorPlugin.class);

    private Properties properties;

    @Override
    public Object intercept(Invocation invoker) throws Throwable {

        Object[] queryArgs = invoker.getArgs();
        MappedStatement ms = (MappedStatement) queryArgs[MAPPED_STATEMENT_INDEX];
        Object parameterObject = queryArgs[PARAMETER_INDEX];
        // 插入日志本身不拦截SQL
        if (Strings.matches(".*insert.*", ms.getId().toLowerCase())
                && (parameterObject instanceof OperationLog || parameterObject instanceof OperationSql)) {
            return invoker.proceed();
        }
        BoundSql boundSql = ms.getBoundSql(parameterObject);
        String sql = boundSql.getSql();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        //根据配置的SQL和传进来的参数进行处理生成可在pl/sql中运行的SQL
        if (parameterMappings != null) {
            ObjectFactory objectFactory =  new DefaultObjectFactory();
            ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
            ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
            MetaObject metaObject = parameterObject == null ? null : MetaObject
                    .forObject(parameterObject,objectFactory, objectWrapperFactory,reflectorFactory);
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    Object value;
                    String propertyName = parameterMapping.getProperty();
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                    if (parameterObject == null) {
                        value = null;
                    } else if (ms.getConfiguration().getTypeHandlerRegistry().hasTypeHandler(
                            parameterObject.getClass())) {
                        value = parameterObject;
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        value = boundSql.getAdditionalParameter(propertyName);
                    } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)
                            && boundSql.hasAdditionalParameter(prop.getName())) {
                        value = boundSql.getAdditionalParameter(prop.getName());
                        if (value != null) {
                            value = MetaObject.forObject(value,objectFactory, objectWrapperFactory,reflectorFactory).getValue(
                                    propertyName.substring(prop.getName().length()));
                        }
                    } else {
                        value = metaObject == null ? null : metaObject.getValue(propertyName);
                    }
                    if (value != null) {
                        boolean valueIsString = value instanceof String;
                        if (valueIsString && Strings.containsAny(value.toString(), "$")) {
                            value = ((String)value).replaceAll("\\$","\\\\\\$");
                        }
                        sql = sql.replaceFirst("\\?", valueIsString ? "'" + value + "'" : value.toString());
                    } else {
                        sql = sql.replaceFirst("\\?", "null");

                    }
                }
            }

            if (properties != null &&
                    Strings.equals(properties.getProperty("printSql", "false"),"true")) {
                Lang.printlnf("当前运行的SQL[%s]:",ms.getId());
                Lang.printlnf("\t\n%s",sql);
            }
        }

        OperationLog log = LogHolder.getLog();
        if (log != null) {
            String sqlType = ms.getSqlCommandType().name();
            DefaultOperationSql operationSql = new DefaultOperationSql(ms.getId(), sqlType, sql,
                    null, log);
            log.addOperationSql(operationSql);
            if (logger.isDebugEnabled()) {
                logger.debug(String.format("current module:%s\ncurrent sql:%s", log
                        .getOperatePath(), sql));
            }
        }

        return invoker.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties p) {
        this.properties = p;
    }

}
