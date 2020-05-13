
package com.dc.framework.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;

import com.dc.framework.io.Files;
import com.dc.framework.lang.Arrays;
import com.dc.framework.lang.Strings;
import com.dc.framework.lang.text.MessageResource;
import com.dc.framework.lang.text.SimpleMessageResource;
import com.dc.framework.lang.text.SpringMessageResource;

/**
 * 异常处理类，主要功能：异常转换、错误处理、错误消息获取及定义。
 */
public class ExceptionHandler {
    
    /**
     * 默认的内部消息文件
     */
    public static final MessageResource INNER_MSG = new SimpleMessageResource(
            "com.cmsz.framework.exception.msg.error", Locale.CHINA);
    
    /**
     * 消息类型
     */
    protected Locale locale = Locale.CHINA;
    
    /**
     * 业务的异常消息文件,默认会使用在Spring环境中定义的消息文件
     */
    protected MessageResource businessMessageResource = new SpringMessageResource();
    
    /**
     * 内部的异常消息文件，除非有必要默认不建议修改此
     */
    protected MessageResource innerMessageResource = new SimpleMessageResource(
            "com.cmsz.framework.exception.msg.error", Locale.CHINA);
    
    /**
     * 内部的异常与错误代码映射文件
     */
    protected Properties exceptionMapping = Files
            .loadPropertiesFile("com/cmsz/framework/exception/exception-mapping.properties");
    
    /**
     * 将其他异常转成ApplicationException
     * 
     * @param e
     * @return
     */
    public ApplicationException convert(Exception e) {

        if (e instanceof ApplicationException) {
            return (ApplicationException) e;
        }
        String errorCode = getErrorCode(e);
        if (Strings.isEmpty(errorCode)) {
            errorCode = "00000017";// 未知异常
        }
        String errorMsg = getErrorMessage(errorCode);
        ApplicationException ex = new ApplicationException(errorMsg, e);
        ex.setErrorCode(errorCode);
        return ex;
    }
    
    /**
     * 将异常信息转成错误消息对象
     * 
     * @param e
     * @return
     */
    public ErrorInfo toErrorInfo(Exception e) {

        ApplicationException appException = convert(e);
        String code = appException.getErrorCode();
        String msg = Arrays.isEmpty(appException.getErrorMsgParam()) ? getErrorMessage(code)
                : getErrorMessage(code, appException.getErrorMsgParam());
        StringWriter sw = new StringWriter();
        appException.printStackTrace(new PrintWriter(sw));
        ErrorInfo errInfo = new ErrorInfo(code, msg, sw.toString());
        return errInfo;
        
    }
    
    /**
     * 获取异常对应的消息代码
     * 
     * @param e
     * @return
     */
    public String getErrorCode(Exception e) {

        if (e instanceof ApplicationException) {
            return ((ApplicationException) e).getErrorCode();
        } else {
            String eClsName = e.getClass().getName();
            String errCode = exceptionMapping.getProperty(eClsName);
            return errCode;
        }
    }
    
    /**
     * 获取错误信息
     * 
     * @param code
     * @return
     */
    public String getErrorMessage(String code) {

        String msg = innerMessageResource.getMessage(code);
        if (Strings.isEmpty(msg))
            msg = businessMessageResource.getMessage(code, locale);
        return msg;
    }
    
    /**
     * 获取错误信息
     * 
     * @param code
     * @param params
     * @return
     */
    public String getErrorMessage(String code, String[] params) {

        String msg = innerMessageResource.getMessage(code);
        if (Strings.isNotEmpty(msg)) {
            MessageFormat format = new MessageFormat(msg);
            return format.format(params);
        }
        return businessMessageResource.getMessage(code, locale, params);
    }
    
    /**
     * 设置错误消息的本地化信息
     * 
     * @param locale
     */
    public void setLocale(String locale) {

        if (Strings.isNotEmpty(locale) && Strings.containsAny(locale, "_")) {
            String[] strs = locale.split("_");
            if (strs.length > 1) {
                this.locale = new Locale(strs[0], strs[1]);
                this.innerMessageResource = new SimpleMessageResource(
                        "com.cmsz.framework.exception.msg.error", this.locale);
            }
        }
    }
    
    public Locale getLocale() {

        return locale;
    }
    
    public void setBusinessMessageResource(MessageResource businessMessageResource) {

        this.businessMessageResource = businessMessageResource;
    }
    
    public MessageResource getBusinessMessageResource() {

        return businessMessageResource;
    }
    
    public MessageResource getInnerMessageResource() {

        return innerMessageResource;
    }
    
    public void setInnerMessageResource(MessageResource innerMessageResource) {

        this.innerMessageResource = innerMessageResource;
    }
}
