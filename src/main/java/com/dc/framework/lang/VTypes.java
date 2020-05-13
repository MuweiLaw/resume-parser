package com.dc.framework.lang;

import java.util.Map;

import com.dc.framework.lang.collection.Maps;

/**
 * 封装一些常用的正则表达式
 */
public enum VTypes {
    
    PASSWORD, DBL_BYTE_CHAR, FILE, POST_CODE, EMAIL, IP, PHONE, MOBILE, URL;
    
    public boolean test(String value) {

        return Strings.matches(getRule(this), value);
    }
    
    private static String getRule(VTypes vtype) {

        return rules.get(vtype);
    }
    
    private static void addRule(VTypes vtype, String rule) {

        rules.put(vtype, rule);
    }
    
    private static final Map<VTypes, String> rules = Maps.newMap();
    
    private static final String _PASSWORD = "^(\\w){6,20}$";
    private static final String _DBL_BYTE_CHAR = "[^\\x00-xff]";
    private static final String _FILE = "[^\\/\\*\\.]";
    private static final String _POST_CODE = "^[a-zA-Z0-9 ]{3,12}$";
    private static final String _EMAIL = "^([\\w]+)(.[\\w]+)*@([\\w]+)(.[\\w]{2,4}){1,2}";
    private static final String _IP = "[0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}";
    private static final String _PHONE = "^[+]{0,1}(\\d){1,3}[ ]?([-]?((\\d)|[ ]){1,12})+$";
    private static final String _MOBILE = "^[+]{0,1}(\\d){1,3}[ ]?([-]?((\\d)|[ ]){1,12})+$";
    private static final String _URL = "(((https?)|(ftp))://([\\-\\w]+\\.)+\\w{2,3}(/[%\\-\\w]+(\\.\\w{2,})?)*(([\\w\\-\\.\\?\\\\\\/+@&#;`~=%!]*)(\\.\\w{2,})?)*/?)";
    
    static {
        addRule(VTypes.PASSWORD, _PASSWORD);
        addRule(VTypes.DBL_BYTE_CHAR, _DBL_BYTE_CHAR);
        addRule(VTypes.FILE, _FILE);
        addRule(VTypes.POST_CODE, _POST_CODE);
        addRule(VTypes.PASSWORD, _PASSWORD);
        addRule(VTypes.EMAIL, _EMAIL);
        addRule(VTypes.IP, _IP);
        addRule(VTypes.PHONE, _PHONE);
        addRule(VTypes.MOBILE, _MOBILE);
        addRule(VTypes.URL, _URL);
    }
    
}
