/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * sam 20100111 增加修改历史注释<br/>
 */

package com.dc.framework.lang.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.dc.framework.lang.Objects;
import org.apache.commons.collections.CollectionUtils;


/**
 * 基于Collection接口的工具类
 * 
 */
public abstract class Collections extends CollectionUtils {
    
    /**
     * 将某个Collection转成数组
     * 
     * @param <T>
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Collection<T> c) {

        if (isEmpty(c))
            return null;
        T t = first(c);
        T[] tArray = (T[]) Array.newInstance(t.getClass(), c.size());
        c.toArray(tArray);
        return tArray;
    }
    
    /**
     * 删除列表中的空项
     * 
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T, C extends Collection<T>> C removeIfEmpty(C c) {

        if (isNotEmpty(c)) {
            List<T> l = newList();
            for (T t : c) {
                if (Objects.isEmpty(t))
                    continue;
                l.add(t);
            }
            return (C) l;
        }
        return c;
    }
    
    /**
     * 获取Collection中的第一个对象
     * 
     * @param <T>
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T first(Collection<T> c) {

        return isNotEmpty(c) ? (T) get(c, 0) : null;
    }
    
    /**
     * 获取Collection中的最后一个对象
     * 
     * @param <T>
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T last(Collection<T> c) {

        return isNotEmpty(c) ? (T) get(c, c.size() - 1) : null;
    }
    

    /**
     * 创建一个空的ArrayList
     * 
     * @param <T>
     * @return
     */
    public static <T> List<T> newList() {

        return new ArrayList<T>();
    }
    

    /**
     * 根据一组动态参数创建一个List列表集
     * @param <T>
     * @param objs
     * @return
     */
    public static <T> List<T> list(T... objs) {

        List<T> l = new ArrayList<T>();
        for (T o : objs) {
            l.add(o);
        }
        return l;
    }
    
    /**
     * 根据一组动态参数创建一个链表
     * @param <T>
     * @param objs
     * @return
     */
    public static <T> List<T> linkedList(T... objs) {

        List<T> l = new LinkedList<T>();
        for (T o : objs)
            l.add(o);
        return l;
    }
    
}
