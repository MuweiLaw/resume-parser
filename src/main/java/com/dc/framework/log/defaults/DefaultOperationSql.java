
package com.dc.framework.log.defaults;

import com.dc.framework.dao.StringIdEntity;
import com.dc.framework.log.OperationLog;
import com.dc.framework.log.OperationSql;
import com.dc.framework.orm.id.ID;

/**
 * OperationSql的默认实现
 */
public class DefaultOperationSql extends StringIdEntity implements OperationSql {
    
    @ID
    protected String id;
    protected String sqlName = "";
    protected String sqlType = "";
    protected String sql = "";
    protected String diff = "";
    protected String columns = "";
    
    public DefaultOperationSql() {

    }
    
    public DefaultOperationSql(String sqlName, String sqlType, String sql, String diff,
            OperationLog log) {

        super();
        this.sqlName = sqlName;
        this.sqlType = sqlType;
        this.sql = sql;
        this.diff = diff;
        this.log = log;
    }
    
    public String getSqlName() {

        return sqlName;
    }
    
    public void setSqlName(String sqlName) {

        this.sqlName = sqlName;
    }
    
    public String getSqlType() {

        return sqlType;
    }
    
    public void setSqlType(String sqlType) {

        this.sqlType = sqlType;
    }
    
    public String getSql() {

        return sql;
    }
    
    public void setSql(String sql) {

        this.sql = sql;
    }
    
    public String getDiff() {

        return diff;
    }
    
    public void setDiff(String diff) {

        this.diff = diff;
    }
    
    public OperationLog getLog() {

        return log;
    }
    
    public void setLog(OperationLog log) {

        this.log = log;
    }
    
    public void setColumns(String columns) {

        this.columns = columns;
    }
    
    public String getColumns() {

        return columns;
    }
    
    public String getId() {

        return id;
    }
    
    public void setId(String id) {

        this.id = id;
    }
    
    private OperationLog log;
    
}
