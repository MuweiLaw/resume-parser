package com.dc.framework.log;

/**
 * 操作SQL，执行数据操作时所产生的增、删、改、查SQL
 */
public interface OperationSql {
    
    public String getSqlName();
    
    public String getSql();
    
    public String getSqlType();
    
    public String getDiff();
    
    public String getColumns();
    
    public OperationLog getLog();
}
