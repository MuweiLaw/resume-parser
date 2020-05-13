package com.dc.framework.lang.text;

import java.util.Locale;


/**
 * 基于Spring消息源的消息资源器
 * @author Sam
 *
 */
public class SpringMessageResource implements MessageResource {
    
    @Override
    public String getMessage(String code) {

        return Springs.getMessage(code);
    }
    
    @Override
    public String getMessage(String code, Object[] args) {

        return Springs.getMessage(code, args);
    }
    
    @Override
    public String getMessage(String code, Locale locale) {

        return Springs.getMessage(code, locale);
    }
    
    @Override
    public String getMessage(String code, Locale locale, Object[] args) {

        return Springs.getMessage(code, locale, args);
    }
    
}
