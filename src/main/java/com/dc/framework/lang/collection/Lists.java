package com.dc.framework.lang.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dc.framework.lang.reflect.Converts;
import org.apache.commons.collections.ListUtils;

/**
 * 基于List接口的工具类
 * 
 */
public abstract class Lists extends ListUtils {

    public static <T> T[] toArray(List<T> list) {

        return Collections.toArray(list);
    }
    
    /**
     * 根据索引值取 List中的某个对象值
     * 
     * @param <T>
     * @param list
     * @param index
     * @return
     */
    public static <T> T get(List<T> list, int index) {

        return (Collections.isEmpty(list) ? null : list.get(index));
    }
    
    /**
     * 获取List中的第一个对象，相当于Lists.get(List,0)
     * 
     * @param <T>
     * @param list
     * @return
     */
    public static <T> T first(List<T> list) {

        return get(list, 0);
    }
    
    /**
     * 使用Apache commons中的Convert接口对List中的所有对象进行转型
     * 
     * @param <T>
     * @param src
     * @param toClass
     * @return
     */
    public static <T> List<T> valuesTo(List<?> src, Class<T> toClass) {

        List<T> to = newList();
        if (Collections.isNotEmpty(src)) {
            for (Object o : src) {
                to.add(Converts.convert(o, toClass));
            }
        }
        return to;
    }
    
    /**
     * 根据可变数组创建一个 List
     * 
     * @param <T>
     * @param objs
     * @return
     */
    public static <T> List<T> of(T... objs) {

        return Collections.list(objs);
    }
    
    /**
     * 创建一个空的ArrayList
     * 
     * @param <T>
     * @return
     */
    public static <T> List<T> newList() {

        return Collections.newList();
    }
    
    /**
     * 将结构为list-list的集合中的list条目转成Map
     * 
     * @param c
     * @param keyPrefix
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Map> listsToMap(List c, String keyPrefix) {

        if (Collections.isEmpty(c)) {
            return null;
        }
        List<Map> l = new ArrayList<Map>();
        for (Iterator it = c.iterator(); it.hasNext();) {
            Object rec = it.next();
            if (rec instanceof List)
                l.add(toMap((List) rec, keyPrefix));
        }
        c.clear();
        return l;
    }
    
    /**
     * 将某个集合转成Map,key的规则是keyPrefix+索引
     * 
     * @param c 集合
     * @param keyPrefix 生成Map的key前缀
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map toMap(List c, String keyPrefix) {

        Map m = new HashMap();
        if (Collections.isNotEmpty(c)) {
            int i = 1;
            for (Iterator it = c.iterator(); it.hasNext();) {
                Object o = it.next();
                m.put(keyPrefix + i, o);
                i++;
            }
        }
        return m;
    }
    
}
