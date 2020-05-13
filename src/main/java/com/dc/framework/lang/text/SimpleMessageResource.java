package com.dc.framework.lang.text;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.util.Assert;

import com.dc.framework.lang.Lang;
import com.dc.framework.lang.Strings;
/**
 * 使用ResourceBundle实现的消息资源器
 */
public class SimpleMessageResource implements MessageResource {
    
    private ResourceBundle rb;
    private String path;
    
    public SimpleMessageResource(String path) {

        this(path, Locale.CHINA);
    }
    
    public SimpleMessageResource(String path, Locale l) {

        this.path = path;
        rb = ResourceBundle.getBundle(path, l);
    }
    
    @Override
    public String getMessage(String code) {

        checkResource();
        try {
            return rb.getString(code);
        } catch (Exception e) {
            return Strings.EMPTY;
        }
    }
    
    @Override
    public String getMessage(String code, Object[] args) {

        checkResource();
        try {
            return format(getMessage(code), args);
        } catch (Exception e) {
            return Strings.EMPTY;
        }
    }
    
    @Override
    public String getMessage(String code, Locale locale) {

        checkResource();
        try {
            return ResourceBundle.getBundle(path, locale).getString(code);
        } catch (Exception e) {
            return Strings.EMPTY;
        }
    }
    
    @Override
    public String getMessage(String code, Locale locale, Object[] args) {

        checkResource();
        try {
            String msg = ResourceBundle.getBundle(path, locale).getString(code);
            return format(msg, args);
        } catch (Exception e) {
            return Strings.EMPTY;
        }
    }
    
    private String format(String msg, Object[] args) {

        MessageFormat mf = new MessageFormat(msg);
        return mf.format(args);
    }
    
    private void checkResource() {

        Assert.notNull(rb, "指定的消息资源路径不存在或者文件不存在");
    }
    
    public static void main(String[] s) {

        MessageResource mr = new SimpleMessageResource("com.cmsz.framework.exception.msg.error");
        Lang.println(mr.getMessage("00000000"));
    }
    
}
