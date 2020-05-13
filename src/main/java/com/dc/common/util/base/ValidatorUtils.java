package com.dc.common.util.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidatorUtils {
	
	/**
	* 正则表达式：验证邮箱
	*/
    public static final String REGEX_PHONE = "^((13)|(14)|(15)|(16)|(17)|(18)|(19))\\d{9}$";
	
	/**
	* 正则表达式：验证邮箱
	*/
//    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	public static final String REGEX_EMAIL =  "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$";
    /**
     * 正则表达式：验证用户名（8-16位数字加字母）
     */
    public static final String REGEX_USERNAME = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
    
    /**
     * 正则表达式：是否为企业子账号 CA+phone+\d{2}
     */
    public static final String REGEX_SUB_CCOMPANY="^CA((13)|(14)|(15)|(16)|(17)|(18)|(19))\\d{9}\\d{2}$";
	/**
	 * 校验手机号是否合法
	 * @param phone
	 */
	public static boolean isPhone(String phone){
	    if (phone.length() != 11) {
//	    	throw new ProcessException("手机号应为11位数",ProcessException.SHOW_ERROR);
	    	return false;
	    } else {
	        Pattern p = Pattern.compile(REGEX_PHONE);
	        Matcher m = p.matcher(phone);
	        boolean isMatch = m.matches();
	        if (!isMatch) {
//	        	throw new ProcessException("请填入正确的手机号",ProcessException.SHOW_ERROR);
	        	return false;
	        }
	        return true;
	    }
	}
	
	public static boolean isEmail(String email){
		return Pattern.matches(REGEX_EMAIL, email);
	}
	
	public static boolean isUserName(String userName){
		return Pattern.matches(REGEX_USERNAME, userName);
	}
	
	public static boolean isSubCompany(String userName){
		return Pattern.matches(REGEX_SUB_CCOMPANY, userName);
	}
	
	public static void main(String[] args) {
//		isPhone("12000000000");
		
		System.out.println(isEmail("123wangyi.com"));
		
		String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";        
		 
        String value = "aaa";  // 长度不够
        System.out.println(value.matches(regex));
 
        value = "1111aaaa1111aaaaa";  // 太长
        System.out.println(value.matches(regex));
 
        value = "111111111"; // 纯数字
        System.out.println(value.matches(regex));
 
        value = "aaaaaaaaa"; // 纯字母
        System.out.println(value.matches(regex));
 
        value = "####@@@@#"; // 特殊字符
        System.out.println(value.matches(regex));
 
        value = "1111aaaa";  // 数字字母组合
        System.out.println(value.matches(regex));
 
        value = "aaaa1111"; // 数字字母组合
        System.out.println(value.matches(regex));
 
        value = "aa1111aa";    // 数字字母组合
        System.out.println(value.matches(regex));
 
        value = "11aaaa11";    // 数字字母组合
        System.out.println(value.matches(regex));
 
        value = "aa11aa11"; // 数字字母组合
        System.out.println(value.matches(regex));
        String regex1="^CA((13)|(14)|(15)|(16)|(17)|(18)|(19))\\d{9}\\d{2}$";
        value="CA1355555555501";
        System.out.println(value.matches(regex1));
	}
}
