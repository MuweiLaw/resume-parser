
package com.dc.framework.log.defaults;

import java.util.List;

import com.dc.framework.log.OperationLog;
import com.dc.framework.log.LoggingProvider;
import com.dc.framework.log.OperationSql;
import com.dc.framework.orm.id.IdHelper;
import com.dc.framework.service.SimpleServiceBase;

/**
 * 日志记录器的IBatis3实现
 */
public class MybatisLoggingProvider extends SimpleServiceBase<OperationLog, String> implements
        LoggingProvider {
    
    protected Boolean hasDetail;
    
    protected String logSqlId;
    
    protected String detailSqlId;
    
    @Override
    public void logging(OperationLog log) {

        IdHelper.setId(log);
        myBatisDao.getSqlSessionTemplate().insert(logSqlId, log);
        if (isHasDetail()) {
            List<OperationSql> sqls = log.getOperationSqls();
            for (OperationSql sql : sqls) {
                IdHelper.setId(sql);
                myBatisDao.getSqlSessionTemplate().insert(detailSqlId, sql);
            }
        }
    }
    
    public Boolean isHasDetail() {

        return hasDetail;
    }
    
    public void setHasDetail(Boolean hasDetail) {

        this.hasDetail = hasDetail;
    }
    
    public String getLogSqlId() {

        return logSqlId;
    }
    
    public void setLogSqlId(String logSqlId) {

        this.logSqlId = logSqlId;
    }
    
    public String getDetailSqlId() {

        return detailSqlId;
    }
    
    public void setDetailSqlId(String detailSqlId) {

        this.detailSqlId = detailSqlId;
    }
    
}
