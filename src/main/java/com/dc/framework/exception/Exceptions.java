
package com.dc.framework.exception;

public abstract class Exceptions {
    
    /**
     * 创建一个ApplicationException,并指定一个消息key
     * 
     * @param code 对应错误消息文件的key
     * @return
     */
    public static ApplicationException createAppException(String code) {

        ApplicationException appEx = new ApplicationException(ExceptionHandler.INNER_MSG
                .getMessage(code));
        appEx.setErrorCode(code);
        return appEx;
    }
    
    /**
     * 创建一个ApplicationException,并指定一个消息key,和传给消息的参数, 如在消息文件定义某条消息 如下：
     * 
     * <pre>
	 * myerror=this is {0} not a {1}!
	 * </pre>
     * 
     * @param code 对应错误消息文件的key
     * @param params 对应错误消息文件的参数，如上述的{0},{1}
     * @return
     */
    public static ApplicationException createAppException(String code, String[] params) {

        ApplicationException appEx = new ApplicationException(ExceptionHandler.INNER_MSG
                .getMessage(code, params));
        appEx.setErrorCode(code);
        appEx.setErrorMsgParam(params);
        return appEx;
    }
    
    /**
     * 创建一个ApplicationException,并指定一个消息key、父类异常消息、被包装的异常
     * 
     * @param code 对应错误消息文件的key
     * @param msg 传给父类的Message
     * @param throwable 被包装的异常，注：此异常不一定是起点异常
     * @return
     */
    public static ApplicationException createAppException(String code, String msg,
        Throwable throwable) {

        ApplicationException appEx = new ApplicationException(msg, throwable);
        appEx.setErrorCode(code);
        return appEx;
    }
    
    /**
     * 创建一个ApplicationException,并指定一个消息key、传给消息的参数、父类异常消息、被包装的异常
     * 
     * @param code 对应错误消息文件的key
     * @param params 传给父类的Message
     * @param throwable 被包装的异常，注：此异常不一定是起点异常
     * @return
     */
    public static ApplicationException createAppException(String code, String[] params,
        Throwable throwable) {

        ApplicationException appEx = new ApplicationException(throwable);
        appEx.setErrorCode(code);
        appEx.setErrorMsgParam(params);
        return appEx;
    }
    
}
