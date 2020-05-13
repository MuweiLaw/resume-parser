/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * sam 20100111 增加修改历史注释<br/>
 */

package com.dc.framework.lang;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.dc.framework.lang.collection.Lister;
import com.dc.framework.lang.collection.Lists;
import com.dc.framework.lang.reflect.Converts;
import org.apache.commons.lang.ArrayUtils;


/**
 * 数组操作工具类
 * 
 */
public abstract class Arrays extends ArrayUtils {
    
    /**
     * 
     * @param intArray
     * @return
     */
    public static short[] toShorts(int... intArray) {

        if (intArray != null) {
            short[] shortArray = new short[intArray.length];
            for (int i = 0; i < intArray.length; i++) {
                shortArray[i] = (short) intArray[i];
            }
        }
        return null;
    }
    
    /**
     * 将一个指定类型的数组转成其他类型的数组
     * 
     * @param type 要转的类型
     * @param objs　被转的数组
     * @return
     */
    public static <T> T[] to(Class<T> type, Object... objs) {

        List<T> tList = Lists.newList();
        for (Object o : objs) {
            tList.add(Converts.convert(o, type));
        }
        return Lists.toArray(tList);
    }
    
    /**
     * 判断一个数组是否不为空
     * 
     * @param objects
     * @return
     */
    public static boolean isNotEmpty(Object[] objects) {

        return !isEmpty(objects);
    }
    
    /**
     * 判断一个数组是否为空
     * 
     * @param objects
     * @return
     */
    public static boolean isEmpty(Object[] objects) {

        return objects == null || objects.length <= 0;
    }
    
    /**
     * 删除数组中为Empty的项
     * 
     * @param arys
     * @return
     */
    public static <T> T[] removeIfEmpty(T[] arys) {

        if (isEmpty(arys))
            return null;
        return Lister.start(arys).removeIfEmpty().toArray();
    }
    
    /**
     * 快速创建一个数组
     * 
     * @param <T>
     * @param eles
     * @return
     */
    public static <T> T[] of(T... eles) {

        return eles;
    }
    
    /**
     * 将多个数组，合并成一个数组。如果这些数组为空，则返回 null
     * 
     * @param arys 数组对象
     * @return 合并后的数组对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] merge(T[]... arys) {

        Queue<T> list = new LinkedList<T>();
        for (T[] ary : arys)
            if (null != ary)
                for (T e : ary)
                    if (null != e)
                        list.add(e);
        if (list.isEmpty())
            return null;
        Class<T> type = (Class<T>) list.peek().getClass();
        return list.toArray((T[]) Array.newInstance(type, list.size()));
    }
    
    /**
     * 将一个对象添加成为一个数组的第一个元素，从而生成一个新的数组
     * 
     * @param e 对象
     * @param eles 数组
     * @return 新数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] arrayFirst(T e, T[] eles) {

        try {
            if (null == eles || eles.length == 0) {
                T[] arr = (T[]) Array.newInstance(e.getClass(), 1);
                arr[0] = e;
                return arr;
            }
            T[] arr = (T[]) Array.newInstance(eles.getClass().getComponentType(), eles.length + 1);
            arr[0] = e;
            for (int i = 0; i < eles.length; i++) {
                arr[i + 1] = eles[i];
            }
            return arr;
        } catch (NegativeArraySizeException e1) {
            throw Lang.wrapThrow(e1, e1.getMessage());
        }
    }
    
    /**
     * 将一个对象添加成为一个数组的最后一个元素，从而生成一个新的数组
     * 
     * @param e 对象
     * @param eles 数组
     * @return 新数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] arrayLast(T[] eles, T e) {

        try {
            if (null == eles || eles.length == 0) {
                T[] arr = (T[]) Array.newInstance(e.getClass(), 1);
                arr[0] = e;
                return arr;
            }
            T[] arr = (T[]) Array.newInstance(eles.getClass().getComponentType(), eles.length + 1);
            for (int i = 0; i < eles.length; i++) {
                arr[i] = eles[i];
            }
            arr[eles.length] = e;
            return arr;
        } catch (NegativeArraySizeException e1) {
            throw Lang.wrapThrow(e1, e1.getMessage());
        }
    }
}
