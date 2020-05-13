package com.dc.framework.jdbc.dialect;


/**
 * 基于Oracle的SQL分页实现
 * 
 * @author Badqiu(rapid-framework作者)
 */
public class OracleDialect extends Dialect {
    
    public boolean supportsLimit() {

        return true;
    }
    
    public boolean supportsLimitOffset() {

        return true;
    }
    
    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit,
        String limitPlaceholder) {

        sql = sql.trim();
        boolean isForUpdate = false;
        if (sql.toLowerCase().endsWith(" for update")) {
            sql = sql.substring(0, sql.length() - 11);
            isForUpdate = true;
        }
        
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
        if (offset > 1) {
            pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
        } else {
            pagingSelect.append("select * from ( ");
        }
        pagingSelect.append(sql);
        if (offset > 1) {
            pagingSelect.append(" ) row_  where rownum < " + limit + "  ) where rownum_ >= "
                    + offset);
        } else {
            pagingSelect.append(" ) where rownum <= " + limitPlaceholder);
        }
        
        if (isForUpdate) {
            pagingSelect.append(" for update");
        }
        return pagingSelect.toString();
        
    }
    
}
