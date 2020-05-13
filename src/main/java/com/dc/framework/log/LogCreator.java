package com.dc.framework.log;

/**
 * 日志对象创建器，日志处理器会使用此接口来创建日志信息对象，如果创建器返回一个空的对象，则
 * 认为此次操作不需要记录(一般由具体的系统来实现此接口，这样可以做到让具体的系统判断是否要记录日志)
 */
public interface LogCreator {
    /**
     * 创建一个日志信息对象
     * @return
     */
    public OperationLog create();
}
