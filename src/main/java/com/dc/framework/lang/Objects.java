/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * sam 20100111 增加修改历史注释<br/>
 */

package com.dc.framework.lang;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import com.dc.framework.lang.collection.Collections;
import com.dc.framework.lang.collection.Maps;
import org.apache.commons.lang.ObjectUtils;

/**
 * object操作工具类
 */
public abstract class Objects extends ObjectUtils {
    
    public static final Object EMPTY = new Object();
    
    /**
     * 获取某个对象的类型
     * @param <T>
     * @param o 对象
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClass(T o) {

        return (Class<T>) (o != null ? o.getClass() : Object.class);
    }
    
    /**
     * 判断某个对象是否是数组类型
     * @param o
     * @return
     */
    public static boolean isArray(Object o) {

        return getClass(o).isArray();
    }
    
    /**
     * 判断某个对象是否是Annotation类型
     * @param o
     * @return
     */
    public static boolean isAnnotation(Object o) {

        return getClass(o).isAnnotation();
    }
    
    /**
     * 判断某个对象是否是接口
     * @param o
     * @return
     */
    public static boolean isInterface(Object o) {

        return getClass(o).isInterface();
    }
    
    /**
     * 对象为空转换,如果指定的对象o为null，则返回指定的对象v
     * @param o 判断的对象
     * @param v 判断的对象为空返回的对象
     * @return
     */
    public static Object nvl(Object o, Object v) {

        return (o == null) ? v : o;
    }
    
    /**
     * 数组toString功能
     * @param objs
     * @return
     */
    public static String toString(Object[] objs) {

        if (isEmpty(objs))
            return "{}";
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(Strings.join(objs, ",")).append("}");
        return sb.toString();
    }
    
    /**
	 * 判断某个JAVA对象是否为空
	 * @param o 任何JAVA对象
	 * @return true表示对象不为空，不为空包含了空引用及空值,如String s=""，这时的对象应该是空的；false反之
	 */
    public static boolean isEmpty(Object o) {

        if (o == null)
            return true;
        if (o instanceof String)
            return Strings.isEmpty((String) o);
        else if (o instanceof Collection<?>)
            return Collections.isEmpty(Collection.class.cast(o));
        else if (o instanceof Map<?, ?>)
            return Maps.isEmpty(Map.class.cast(o));
        else {
            Class<?> t = o.getClass();
            if (t.isArray())
                return Array.getLength(o) <= 0;
            else
                return false;
        }
        
    }
    
    /**
     * 创建某个类的实例
     * @param <T>
     * @param type
     * @return
     */
    public static <T> T newObject(Class<T> type) {

        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            throw Lang.wrapThrow(e, "实例化类型为\"%s\"时出错了！", type.getName());
        } catch (IllegalAccessException e) {
            throw Lang.wrapThrow(e, "实例化类型为\"%s\"时出错了！", type.getName());
        }
    }
    
    /**
     * 判断某个JAVA对象是否不为空
     * @param o 任何JAVA对象
     * @return
     */
    public static boolean isNotEmpty(Object o) {

        return !isEmpty(o);
    }
    
}
