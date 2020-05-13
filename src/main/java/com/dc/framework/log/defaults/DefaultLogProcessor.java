
package com.dc.framework.log.defaults;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.dc.framework.lang.Strings;
import com.dc.framework.log.LogCreator;
import com.dc.framework.log.LogInitialization;
import com.dc.framework.log.LogProcessor;
import com.dc.framework.log.LoggingProvider;
import com.dc.framework.log.OperationLog;
import com.dc.framework.log.OperationStatus;
import com.dc.framework.log.annotations.Logging;
import com.dc.framework.log.annotations.UnLogging;

/**
 * 默认的日志拦截处理器，使用jdk5的纯程池实现异步日志处理，并且支持Logging 和UnLogging的注解，来设置 某个方法是否需要记录日志
 * 
 */
public class DefaultLogProcessor implements LogProcessor {
    
    protected static final ExecutorService POOL = Executors.newFixedThreadPool(20);
    /**
     * 日志持久化提供者，可以是jdbc，也可是基于ibatis或者其他
     */
    protected LoggingProvider loggingProvider;
    
    /**
     * 日志初始化，根据不同项目的需求应该提供不同的初始化处理器，框架不提供
     */
    protected LogInitialization logInitialization;
    
    /**
     * 日志信息工厂
     */
    protected LogCreator logCreator;
    
    /**
     * 记录日志为同步或者异步，true为同步
     */
    protected boolean synch = false;
    
    /**
     * 日志处理器入口
     */
    @SuppressWarnings("unchecked")
    public void process(Class target, Method method, OperationStatus status) {

        try {
            if (isNeedLogging(target, method)) {
                OperationLog log = getProcessedLog(status);
                if (log != null) {
                    if (synch) {
                        loggingProvider.logging(log);
                    } else {
                        asynchLogging(target, method, log);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * 初始化日志信息
     */
    @SuppressWarnings("unchecked")
    @Override
    public void init(Class type, Method method) {

        if (isNeedLogging(type, method)) {
            DefaultOperationLog log = createOperationLog();
            initLog(type, method, log);
        }
    }
    
    @SuppressWarnings("unchecked")
    protected void asynchLogging(Class target, Method method, OperationLog log) {

        Runnable task = new LoggingTask(loggingProvider, log);
        POOL.execute(task);
    }
    
    protected OperationLog getProcessedLog(OperationStatus status) {

        OperationLog log = LogHolder.getLog();
        if (log != null) {
            if (status == OperationStatus.FAIL) {
                ((DefaultOperationLog) log).setStatus("0");
            }
            
            if (status == OperationStatus.SUCCESS) {
                ((DefaultOperationLog) log).setStatus("1");
            }
        }
        LogHolder.setLog(null);
        return log;
    }
    
    /**
     * 如果方法注释了@Logging()的话，会将其信息复盖默认的信息
     * 
     * @param target
     * @param method
     * @param log
     */
    @SuppressWarnings("unchecked")
    protected void initLog(Class target, Method method, DefaultOperationLog log) {

        if (logInitialization != null) {
            logInitialization.init(log);
        }
        
        //
        // log.setOperator(Securitys.getCurrentUserName());
        // 如果被拦截的方法有注解了Logging的话，会重设OperationLog的信息
        Logging li = (Logging) method.getAnnotation(Logging.class);
        if (li != null) {
            if (Strings.isNotBlank(li.sensitivity()))
                log.setSensitivity(li.sensitivity());
            if (Strings.isNotBlank(li.moduleCode()))
                log.setModuleCode(li.moduleCode());
            if (Strings.isNotBlank(li.moduleName()))
                log.setModuleName(li.moduleName());
            if (Strings.isNotBlank(li.operationType()))
                log.setOperateType(li.operationType());
            if (Strings.isNotBlank(li.operationDesc()))
                log.setOperateDesc(li.operationDesc());
        }
        
        LogHolder.setLog(log);
    }
    
    protected DefaultOperationLog createOperationLog() {

        if (logCreator != null) {
            return (DefaultOperationLog) logCreator.create();
        }
        OperationLog log = LogHolder.getLog();
        if (log != null) {
            return (DefaultOperationLog) log;
        }
        return new DefaultOperationLog();
    }
    
    /**
     * 根据注解的annotation确定是否要记录日志
     * 
     * @param target
     * @param method
     * @return
     */
    @SuppressWarnings("unchecked")
    protected boolean isNeedLogging(Class target, Method method) {

        // 读取类或者方法中的Unlogging注解，确定是否要记录日志
        if (method.getAnnotation(UnLogging.class) != null)
            return false;
        UnLogging ul = (UnLogging) target.getAnnotation(UnLogging.class);
        if (ul != null) {
            if (Strings.isBlank(ul.value()))
                return false;
            if (Strings.isNotBlank(ul.value())) {
                String methodName = method.getName();
                if (ul.value().contains(methodName)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public LoggingProvider getLoggingProvider() {

        return loggingProvider;
    }
    
    public void setLoggingProvider(LoggingProvider loggingProvider) {

        this.loggingProvider = loggingProvider;
    }
    
    public LogInitialization getLogInitialization() {

        return logInitialization;
    }
    
    public void setLogInitialization(LogInitialization logInitialization) {

        this.logInitialization = logInitialization;
    }
    
    public void finalize() {

        if (!POOL.isShutdown())
            POOL.shutdown();
    }
    
    public LogCreator getLogCreator() {

        return logCreator;
    }
    
    public void setLogCreator(LogCreator logCreator) {

        this.logCreator = logCreator;
    }
    
    public boolean isSynch() {

        return synch;
    }
    
    public void setSynch(boolean synch) {

        this.synch = synch;
    }
    
}

class LoggingTask implements Runnable {
    
    private LoggingProvider loggingProvider;
    private OperationLog log;
    
    public LoggingTask(LoggingProvider loggingProvider, OperationLog log) {

        this.loggingProvider = loggingProvider;
        this.log = log;
    }
    
    @Override
    public void run() {

        try {
            loggingProvider.logging(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
