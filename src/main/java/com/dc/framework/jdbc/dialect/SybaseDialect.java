package com.dc.framework.jdbc.dialect;

/**
 * 基于SybaseDialect的SQL分页实现
 */
public class SybaseDialect extends Dialect {
    
    public boolean supportsLimit() {

        return false;
    }
    
    public boolean supportsLimitOffset() {

        return false;
    }
    
    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit,
        String limitPlaceholder) {

        throw new UnsupportedOperationException("paged queries not supported");
    }
    
}
