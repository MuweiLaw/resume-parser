package com.dc.framework.lang.text;

import java.util.List;
import java.util.Locale;

import com.dc.framework.lang.Strings;
import com.dc.framework.lang.collection.Lists;
/**
 * 基于多个物理消息源的消息资源器
 */
public class ComboMessageResource implements MessageResource {
    
    private List<MessageResource> resources = Lists.newList();
    
    @Override
    public String getMessage(String code) {

        for (MessageResource r : resources) {
            String msg = r.getMessage(code);
            if (Strings.isNotEmpty(msg))
                return msg;
        }
        return null;
    }
    
    @Override
    public String getMessage(String code, Object[] args) {

        for (MessageResource r : resources) {
            String msg = r.getMessage(code, args);
            if (Strings.isNotEmpty(msg))
                return msg;
        }
        return null;
    }
    
    @Override
    public String getMessage(String code, Locale locale) {

        for (MessageResource r : resources) {
            String msg = r.getMessage(code, locale);
            if (Strings.isNotEmpty(msg))
                return msg;
        }
        return null;
    }
    
    @Override
    public String getMessage(String code, Locale locale, Object[] args) {

        for (MessageResource r : resources) {
            String msg = r.getMessage(code, locale, args);
            if (Strings.isNotEmpty(msg))
                return msg;
        }
        return null;
    }
    
    public void setResources(List<MessageResource> resources) {

        this.resources = resources;
    }
    
    public List<MessageResource> getResources() {

        return resources;
    }
    
}
