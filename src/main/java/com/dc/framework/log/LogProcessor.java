package com.dc.framework.log;

import java.lang.reflect.Method;

/**
 * 日志处理器根据传进来的class和method确定是否要进行日志处理
 */
public interface LogProcessor {
    
	/**
	 * 日志处理
	 * @param type
	 * @param method
	 * @param status
	 */
    @SuppressWarnings("unchecked")
    void process(Class type, Method method, OperationStatus status);
    
    /**
     * 初始化日志信息
     * @param type
     * @param method
     */
    @SuppressWarnings("unchecked")
    void init(Class type, Method method);
}
