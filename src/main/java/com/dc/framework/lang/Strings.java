package com.dc.framework.lang;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.dc.framework.lang.collection.Lists;
import com.dc.framework.lang.collection.Maps;
import com.dc.framework.lang.reflect.Beans;
import com.dc.framework.lang.reflect.ClassWrapper;
import com.dc.framework.lang.reflect.Converts;

/**
 * 扩展commons StringUtils增加一个常用功能
 */
public abstract class Strings extends StringUtils {
    
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final String ENCODING_GBK = "GBK";
    public static final String ENCODING_ISO_8859_1 = "ISO8859_1";
    public static final String EMPTY = "";
    public static final String BLANK = " ";
    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String SEMICOLON = ";";
    public static final String NEW_LINE = "\n";
    
    /**
     * 复制字符串
     * 
     * @param str 字符串
     * @param num 数量
     */
    public static String dup(String str, int num) {

        if (isEmpty(str) || num <= 0)
            return EMPTY;
        StringBuilder sb = new StringBuilder(str.length() * num);
        for (int i = 0; i < num; i++)
            sb.append(str);
        return sb.toString();
    }
    
    /**
     * 检测输入的字符串是含有多个指定的字符串中的任何一个
     * 
     * @param str 被检测的字符串
     * @param subStrs 字符串集
     * @return
     */
    public static boolean containsAny(String str, String... subStrs) {

        if (isEmpty(str))
            return false;
        for (String s : subStrs) {
            if (contains(str, s))
                return true;
        }
        return false;
    }
    
    /**
     * 检测输入的字符串是含有多个指定的字符串
     * 
     * @param str 被检测的字符串
     * @param subStrs 字符串集
     * @return
     */
    public static boolean containsMany(String str, String... subStrs) {

        if (isEmpty(str))
            return false;
        for (String s : subStrs) {
            if (!contains(str, s))
                return false;
        }
        return true;
    }
    
    /**
     * 检测输入的字符串是否符合指定的正则表达式
     * 
     * @param regex 正则表达式
     * @param str 输入的字符串
     * @return
     */
    public static boolean matches(String regex, String str) {

        if (isEmpty(regex))
            return true;
        return Pattern.matches(regex, str);
    }
    
    /**
     * 根据指定的表达式查找和输入的字符串查找匹配的串
     * 
     * @param regex 正则表达式
     * @param str 被查找匹配的字符串
     * @return
     */
    public static List<String> findMatches(String regex, String str) {

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        List<String> matches = Lists.newList();
        while (m.find()) {
            matches.add(m.group());
        }
        return matches;
    }
    
    /**
     * 检测某个字符串是否为空串，是就返回指定的默认串
     * 
     * @param str 被检测的字符串
     * @param l 默认串
     * @return
     */
    public static String nvl(String str, String l) {

        return defaultIfEmpty(str, l);
    }
    
    public static String nvl(String str) {

        return defaultIfEmpty(str, EMPTY);
    }
    
    /**
     * 将一个list用指定字符串连接成一个新的串,如
     * 
     * <pre>
	 * List l = Lists.of("a","b","c","d");
	 * Strings.join(l,",")=[a,b,c,d]
	 * </pre>
     * 
     * @param c
     * @param joinStr
     * @return
     */
    public static String join(Collection c, String joinStr) {
        return join(c.toArray(), joinStr);
    }
    
    /**
     * @param objs
     * @param joinStr
     * @return
     */
    public static String join(Object[] objs, String joinStr) {

        if (Objects.isEmpty(objs))
            return EMPTY;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = objs.length; i < len; i++) {
            sb.append(Objects.toString(objs[i]));
            if (i < (len - 1))
                sb.append(joinStr);
        }
        return sb.toString();
    }
    
    /**
     * 分割一个字符串，并将分割后字符串数组映射到一个指定类型的对象的属性中
     * 
     * @param str 被分割解析的字符串
     * @param splitStr 分割符
     * @param type 指定的对象
     * @param properties 映射的属性
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T splitTo(String str, String splitStr, Class<T> type, String... properties) {

        String[] values = Strings.split(str, splitStr);
        int index = 0;
        if (ClassWrapper.wrap(type).is(Map.class)) {
            Map<String, String> m = Maps.newMap();
            for (String p : properties) {
                if (index == (values.length))
                    break;
                m.put(p, values[index]);
                index++;
            }
            return (T) m;
        }
        T t = Objects.newObject(type);
        for (String p : properties) {
            Beans.setProperty(t, p, values[index]);
            index++;
        }
        return t;
    }
    
    /**
     * 根据一个正则式，将字符串拆分成数组，空元素将被忽略
     * 
     * @param s 字符串
     * @param regex 正则式
     * @return 字符串数组
     */
    public static String[] splitIgnoreBlank(String s, String regex) {

        return isEmpty(s) ? null : Arrays.removeIfEmpty(split(s, regex));
    }
    
    public static String[] splitIgnoreBlank(String s) {

        return splitIgnoreBlank(s, Strings.COMMA);
    }
    
    /**
     * 分割字符串并作转型
     * 
     * @param <T> 要转的目标类型
     * @param src 要分割的字符串
     * @param regex 分割的正则表达式
     * @param type 要转的目标类型
     * @return 分割转型后的数组
     */
    public static <T> T[] splitTo(String src, String regex, Class<T> type) {

        String[] ss = splitIgnoreBlank(src, regex);
        List<T> tList = Lists.newList();
        for (String s : ss) {
            tList.add(Converts.convert(s, type));
        }
        return Lists.toArray(tList);
    }
    
    /**
     * 计算split后的字符串数组长度
     * 
     * @param str
     * @param splitStr
     * @return
     */
    public static Integer lengthBySplit(String str, String splitStr) {

        return Strings.split(str, splitStr).length;
    }
    
    /**
     * 将某个字符串的首字符小写
     * 
     * @param str
     * @return
     */
    public static String lowerFirst(String str) {

        if (Strings.isNotBlank(str)) {
            return str.substring(0, 1).toLowerCase() + (str.length() > 1 ? str.substring(1) : "");
        }
        return str;
    }
    
    /**
     * 编码转换
     * 
     * @param str 要转换的字符串
     * @param srcEncode 源编码
     * @param targetEncode 目标编码
     * @return
     */
    public static String changeEncoding(String str, String srcEncode, String targetEncode) {

        if (isNotEmpty(str)) {
            byte[] srcByte = null;
            try {
                srcByte = str.getBytes(srcEncode);
            } catch (UnsupportedEncodingException e) {
                throw Lang.makeThrow("指定源编码[%s]错误!", srcEncode);
            }
            
            try {
                str = new String(srcByte, targetEncode);
            } catch (UnsupportedEncodingException e) {
                throw Lang.makeThrow("指定目标编码[%s]错误!", targetEncode);
            }
            return str;
        }
        return EMPTY;
    }
    
    /**
     * 更换字符串的编码格式，不指定源编码格式
     * 
     * @param str 要更换编码的字符串
     * @param encoding 编码格式
     * @return
     */
    public static String changeEncoding(String str, String encoding) {

        if (isNotEmpty(str)) {
            try {
                return new String(str.getBytes(), encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str;
    }
    
    public static String iso(String str) {

        return changeEncoding(str, ENCODING_ISO_8859_1);
    }
    
    public static String gbk(String str) {

        return changeEncoding(str, ENCODING_GBK);
    }
    
    public static String utf8(String str) {

        return changeEncoding(str, ENCODING_UTF_8);
    }
    
    public static String gbk2ISO(String str) {

        return changeEncoding(str, ENCODING_GBK, ENCODING_ISO_8859_1);
    }
    
    public static String gbk2UTF8(String str) {

        return changeEncoding(str, ENCODING_GBK, ENCODING_UTF_8);
    }
    
    public static String iso2GBK(String str) {

        return changeEncoding(str, ENCODING_ISO_8859_1, ENCODING_GBK);
    }
    
    public static String iso2UTF8(String str) {

        return changeEncoding(str, ENCODING_ISO_8859_1, ENCODING_UTF_8);
    }
    
    public static String utf82GBK(String str) {

        return changeEncoding(str, ENCODING_UTF_8, ENCODING_GBK);
    }
    
    public static String utf82ISO(String str) {

        return changeEncoding(str, ENCODING_UTF_8, ENCODING_ISO_8859_1);
    }
    
    public static String urlEncode(String str) {
    	return urlEncode(str,ENCODING_UTF_8);
    }
    
    public static String urlEncode(String str,String encoding) {
		try {
			return java.net.URLEncoder.encode(str,encoding);
		} catch (UnsupportedEncodingException e) {
			throw Lang.wrapThrow(e,"encode fail:the encoding[%s] is unsupport!",encoding);
		}
    }
    
    public static String urlDecode(String str) {
    	return urlDecode(str,ENCODING_UTF_8);
    }
    
    
    public static String urlDecode(String str,String encoding) {
    	try {
			return java.net.URLDecoder.decode(str,encoding);
		} catch (UnsupportedEncodingException e) {
			throw Lang.wrapThrow(e,"decode fail:the encoding[%s] is unsupport!",encoding);
		}
    }
    
    public static void main(String[] args) throws Exception {
    	String s = "你好";
    	Lang.println(iso(s));
    	Lang.println(changeEncoding(s,"utf-8","iso8859-1"));
    	Lang.println(urlEncode(s));
    }
    
}
