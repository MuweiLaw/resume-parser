/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * sam 20100111 增加修改历史注释<br/>
 */

package com.dc.framework.lang;

import com.dc.framework.lang.collection.Collections;
import com.dc.framework.lang.collection.Maps;
import com.dc.framework.lang.reflect.ClassWrapper;

import java.util.List;
import java.util.Map;

/**
 * 主要提供一些常用的方法，如异常封装，对象是否为空等
 * 
 */
public abstract class Lang {
    
	/**
	 * 简化System.out.print
	 * @param objs
	 */
    public static void print(Object objs) {

        System.out.print(objs);
    }
    
    /**
     * 简化System.out.println
     * @param objs
     */
    public static void println(Object objs) {

        System.out.println(objs);
    }
    
    /**
     * 简化System.out.println
     */
    public static void println() {

        System.out.println();
    }
    
    /**
     * 简化System.out.print,并提供格式化功能
     * @param fmt 格式化的字符串
     * @param args 格式化参数
     * @see #java.lang.String.format(String,String[])
     */
    public static void printf(String fmt, Object... args) {

        System.out.print(String.format(fmt, args));
    }
    
    /**
     * 简化System.out.println,并提供格式化功能
     * @param fmt 格式化的字符串
     * @param args 格式化参数
     * @see #java.lang.String.format(String,String[])
     */
    public static void printlnf(String fmt, Object... args) {

        System.out.println(String.format(fmt, args));
    }
    
    /**
     * 创建一个运行时异常
     * @param fmt 格式化的字符串
     * @param args 格式化参数
     * @see #java.lang.String.format(String,String[])
     * @return
     */
    public static RuntimeException makeThrow(String fmt, Object... args) {

        return new RuntimeException(String.format(fmt, args));
    }
    
    /**
     * 将提供的异常对象包装成运行时异常
     * @param e 任何异常地象
     * @return
     */
    public static RuntimeException wrapThrow(Exception e) {

        return new RuntimeException(e);
    }
    
    /**
     * 将提供的异常对象包装成运行时异常，并重设置异常对象概念信息 
     * @param e 任何异常地象
     * @param fmt 格式化的字符串
     * @param args 格式化参数
     * @return
     */
    public static RuntimeException wrapThrow(Exception e, String fmt, Object... args) {

        return new RuntimeException(String.format(fmt, args), e);
    }
    
    /**
     * 根据一个异常类型，将使用此类型包装提供的异常对象。
     * @param <T>
     * @param throwClass
     * @param ex
     * @return
     */
    public static <T extends Exception> T wrapThrow(Class<T> throwClass, Exception ex) {

        return ClassWrapper.wrap(throwClass).newOne(ex);
    }
    
    /**
     * 根据一个异常类型，将使用此类型包装提供的异常对象，并重设置异常对象概念信息 。
     * @param <T>
     * @param throwClass
     * @param ex
     * @param fmt
     * @param args
     * @return
     */
    public static <T extends Exception> T wrapThrow(Class<T> throwClass, Exception ex, String fmt,
        Object... args) {

        return ClassWrapper.wrap(throwClass).newOne(ex, String.format(fmt, args));
    }
    
    /**
     * 根据一个异常类型，将使用此类型包装提供的异常对象，并重设置异常对象概念信息 。
     * @param <T>
     * @param throwClass
     * @param fmt
     * @param args
     * @return
     */
    public static <T extends Exception> T wrapThrow(Class<T> throwClass, String fmt, Object... args) {

        return ClassWrapper.wrap(throwClass).newOne(String.format(fmt, args));
    }
    
    /**
     * 创建一个List对象
     * @param <T>
     * @param objs
     * @return
     */
    public static <T> List<T> list(T... objs) {

        return Collections.list(objs);
    }
    
    /**
     * 创建一个Map对象
     * @param <K>
     * @param <V>
     * @param keyValues
     * @return
     */
    public static <K, V> Map<K, V> map(Object... keyValues) {
        return Maps.map(keyValues);
    }
}
