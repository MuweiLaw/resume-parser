package com.dc.framework.log;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 基于spring AOP的日志拦截处理，但这只是一个入口点，最终实现决定和日志处理的还是LogProcessor
 *
 */
public class SpringLogInterceptor implements MethodInterceptor {
    
    protected LogProcessor logProcessor;
    
    @SuppressWarnings("unchecked")
    public Object invoke(MethodInvocation mi) throws Throwable {

        Class target = mi.getClass();
        Method method = mi.getMethod();
        try {
            logProcessor.init(target, method);
            Object result = mi.proceed();
            logProcessor.process(target, method, OperationStatus.SUCCESS);
            return result;
        } catch (Exception ex) {
            logProcessor.process(target, method, OperationStatus.FAIL);
            throw ex;
        }
    }
    
    public LogProcessor getLogProcessor() {

        return logProcessor;
    }
    
    public void setLogProcessor(LogProcessor logProcessor) {

        this.logProcessor = logProcessor;
    }
    
    public static void main(String[] s) {

    }
    
}
