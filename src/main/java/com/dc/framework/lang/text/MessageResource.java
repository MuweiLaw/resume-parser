package com.dc.framework.lang.text;

import java.util.Locale;

/**
 * 消息资源器，定义一组获取消息资源接口，用于从不同的消息来源获取某个定义的消息，消息的定义可以是基于文本文件，
 * 也可以从数据库中定义的等等，每个消息应该有这些属性：消息代码、消息本、消息参数[可选的]。
 */
public interface MessageResource {
    /**
     * 获取一个消息文本
     * @param code 消息代码
     * @return
     */
    public String getMessage(String code);
    
    /**
     * 获取一个消息文本
     * @param code 消息代码
     * @param args 消息参数
     * @return
     */
    public String getMessage(String code, Object[] args);
    
    /**
     * 获取一个本地化的消息文本
     * @param code 消息代码
     * @param locale 本地化信息
     * @return
     */
    public String getMessage(String code, Locale locale);
    
    /**
     * 获取一个本地化的消息文本
     * @param code 消息代码
     * @param locale 本地化信息
     * @param args 消息参数
     * @return
     */
    public String getMessage(String code, Locale locale, Object[] args);
}
