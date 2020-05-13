
package com.dc.framework.log.defaults;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.dc.framework.lang.Strings;
import com.dc.framework.lang.reflect.Beans;
import com.dc.framework.log.OperationLog;
import com.dc.framework.log.LoggingProvider;
import com.dc.framework.log.OperationSql;
import com.dc.framework.orm.id.IdHelper;

/**
 * 日志记录器的JDBC实现
 */
public class JdbcLoggingProvider extends JdbcDaoSupport implements LoggingProvider {
    
    protected String insertSql = DEFAULT_INSERT_SQL;
    protected String detailInsertSql = DEFAULT_DETAIL_INSERT_SQL;
    protected String insertProperties = DEFAULT_INSERT_PROPERTIES;
    protected String detailInsertProperties = DEFAULT_DETAIL_INSERT_PROPERTIES;
    protected boolean hasDetail = true;
    
    @Override
    public void logging(OperationLog log) {

        IdHelper.setId(log);
        Object[] insertValues = getValues(log, getInsertProperties());
        String insertSql = getInsertSql();
        getJdbcTemplate().update(insertSql, insertValues);
        if (hasDetail) {
            List<OperationSql> sqls = log.getOperationSqls();
            if (sqls != null) {
                for (OperationSql sql : sqls) {
                    IdHelper.setId(sql);
                    Object[] detailInsertValues = getValues(sql, getDetailInsertProperties());
                    getJdbcTemplate().update(getDetailInsertSql(), detailInsertValues);
                }
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    protected Object[] getValues(Object o, String propertiesStr) {

        if (o != null && Strings.isNotEmpty(propertiesStr)) {
            String[] properties = propertiesStr.split(",");
            List values = new ArrayList();
            for (String p : properties) {
                values.add(Beans.getAnyProperty(o, p));
            }
            return values.toArray();
        }
        return null;
    }
    
    public void setHasDetail(boolean hasDetail) {

        this.hasDetail = hasDetail;
    }
    
    public String getInsertSql() {

        return insertSql;
    }
    
    public void setInsertSql(String insertSql) {

        this.insertSql = insertSql;
    }
    
    public String getDetailInsertSql() {

        return detailInsertSql;
    }
    
    public void setDetailInsertSql(String detailInsertSql) {

        this.detailInsertSql = detailInsertSql;
    }
    
    public String getInsertProperties() {

        return insertProperties;
    }
    
    public void setInsertProperties(String insertProperties) {

        this.insertProperties = insertProperties;
    }
    
    public String getDetailInsertProperties() {

        return detailInsertProperties;
    }
    
    public void setDetailInsertProperties(String detailInsertProperties) {

        this.detailInsertProperties = detailInsertProperties;
    }
    
    private static final String DEFAULT_INSERT_PROPERTIES = "id,operator,clientIp,serverIp,operateType,systemCode,moduleCode,operatePath,status,sensitivity,operateDesc";
    private static final String DEFAULT_INSERT_SQL = "insert into sys_operation_log(" + "		log_id,"
            + "		operator," + "		client_ip," + "		server_ip," + "		operate_type," + "		sys_cd,"
            + "		module_cd," + "		operate_path," + "		status," + "		sensitive_level,"
            + "		note)  values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DEFAULT_DETAIL_INSERT_SQL = "insert into sys_operation_sql("
            + "		REC_ID," + "		LOG_ID," + "		SQL_NAME," + "		SQL,"
            + "		SQL_TYPE) values(?,?,?,?,?)";
    
    private static final String DEFAULT_DETAIL_INSERT_PROPERTIES = "id,log.id,sqlName,sql,sqlType";
    
}
