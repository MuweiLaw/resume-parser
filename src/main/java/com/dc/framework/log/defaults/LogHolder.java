
package com.dc.framework.log.defaults;

import com.dc.framework.log.OperationLog;

/**
 * 日志对象持有器
 */
public class LogHolder {
    
    @SuppressWarnings("unchecked")
    private static final ThreadLocal logTL = new ThreadLocal();
    
    @SuppressWarnings("unchecked")
    public static void setLog(OperationLog log) {

        logTL.set(log);
    }
    
    public static OperationLog getLog() {

        return (OperationLog) logTL.get();
    }
    
}
