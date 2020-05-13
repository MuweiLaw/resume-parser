
package com.dc.framework.exception;

/**
 * 定义一个基于RuntimeException的基类异常。
 * 
 */
public class ApplicationException extends RuntimeException {
    
    private static final long serialVersionUID = -2394147719359810950L;
    
    /**
     * 错误消息代码
     */
    private String errorCode;
    
    /**
     * 传给错误消息的参数
     */
    private String[] errorMsgParam;
    
    public ApplicationException() {

    }
    
    /**
     * Simple wrapper of Throwable Object.
     * 
     * @param e
     */
    public ApplicationException(Throwable e) {

        super(e);
    }
    
    /**
     * Constructor, exception contents the user-defined error information.
     * 
     * @param msg
     * @param e
     */
    public ApplicationException(String msg, Throwable e) {

        super(msg, e);
    }
    
    public ApplicationException(String msg) {

        super(msg);
    }
    
    /**
     * @return the errorCode
     */
    public String getErrorCode() {

        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {

        this.errorCode = errorCode;
    }
    
    public String toString() {

        return "APPLICATION ERROR-" + this.errorCode + " : " + this.getMessage();
    }
    
    public void setErrorMsgParam(String[] errorMsgParam) {

        this.errorMsgParam = errorMsgParam;
    }
    
    public String[] getErrorMsgParam() {

        return errorMsgParam;
    }
}
