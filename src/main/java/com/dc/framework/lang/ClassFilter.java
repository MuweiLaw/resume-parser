/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * sam 20100111 增加修改历史注释<br/>
 */

package com.dc.framework.lang;

/**
 * 基于ClassScaner类搜索器的过滤接口,用于过滤不需要的类
 * 
 */
public interface ClassFilter {
    /**
     * 根据类型进行匹配
     * @param clazz 类对象
     * @return
     */
    boolean classMatches(Class<?> clazz);
    
    /**
     * 根据类型名儿进行匹配
     * @param name 类名称
     * @return
     */
    boolean nameMatches(String name);
}
