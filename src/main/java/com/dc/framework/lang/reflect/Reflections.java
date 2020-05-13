package com.dc.framework.lang.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dc.framework.lang.Arrays;
import com.dc.framework.lang.Lang;
import net.sf.cglib.proxy.Enhancer;

import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

/**
 * @author wx
 * @version 1.0.0
 * @className Reflections
 * @description 反射工具类
 * @date 2019/12/13 16:12
 */
public class Reflections {

    static {
        DateConverter dc = new DateConverter();
        dc.setUseLocaleFormat(true);
        dc.setPatterns(new String[] {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss","yyyyMMdd","yyyyMM" });
        Converts.addConvert(dc, Date.class);
    }

    /**
     * 直接读取对象属性值, 无视private/protected修饰符.
     */
    public static Object getValue(final Object object, final String fieldName) {

        return ClassWrapper.wrap(object).getValue(object, fieldName);
    }

    /**
     * 直接设置对象属性值, 无视private/protected修饰符.
     */
    public static void setValue(final Object object, final String fieldName, final Object value) {

        ClassWrapper.wrap(object).setValue(object, fieldName, value);
    }

    /**
     * 通过反射,获得Class定义中声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getSuperClassGenricType(final Class clazz) {

        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 通过反射,获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     *
     * @param clazz
     * @param index 泛型类型的声明位置
     *        <p>
     *        如下代码，泛型声明< UserInfo,String >中的UserInfo的index为0,String为1，以此类推
     *
     * <pre>
     * 	public  class MyService extends SimpleServiceBase< UserInfo, String > {...}
     * </pre>
     *        </p>
     */
    @SuppressWarnings("unchecked")
    public static Class getSuperClassGenricType(final Class clazz, final int index) {

        return ClassWrapper.wrap(clazz).getSuperClassGenricType(index);
    }

    /**
     * 获取某个方法的所有形参名
     *
     * @param m
     * @return
     */
    public static String[] getParameterNames(Method m) {

        LocalVariableTableParameterNameDiscoverer p = new LocalVariableTableParameterNameDiscoverer();
        String[] ss = p.getParameterNames(m);
        return ss;
    }

    /**
     * 获取某个构造器的所有形参名
     *
     * @param c
     * @return
     */
    public static String[] getParameterNames(Constructor<?> c) {

        LocalVariableTableParameterNameDiscoverer p = new LocalVariableTableParameterNameDiscoverer();
        String[] ss = p.getParameterNames(c);
        return ss;
    }

    /**
     * 获取某个方法某个形参的泛型类型，如List<String>将返回String.class
     *
     * @param m 方法对象
     * @param typeClass
     * @param parameterName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Class<?> getGenericType(Method m, Class<?> typeClass, String parameterName,
                                          int index) {

        Type[] tt = m.getGenericParameterTypes();
        if (Arrays.isEmpty(tt))
            return Object.class;
        String[] pNames = getParameterNames(m);
        Class<?>[] pTypes = m.getParameterTypes();
        if (pNames.length <= index) {
            return Object.class;
        }
        ParameterizedType pt = (ParameterizedType) tt[index];
        Lang.println(pTypes[index]);
        if (pTypes[index].isAssignableFrom(typeClass) && pNames[index].equals(parameterName)) {
            Type[] params = pt.getActualTypeArguments();
            if (Arrays.isNotEmpty(params))
                return (Class) params[0];
        }
        return Object.class;
    }

    /**
     * 获取某个泛型类型的类型
     * @param t
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Class<?> getGenericType(Type t, int index) {

        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] params = pt.getActualTypeArguments();
            if (params != null && params.length > index)
                return (Class) params[index];
        }
        return null;
    }

    /**
     * 判断某个Class是否是原型类型，或者原型包装类
     *
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean isPrimitive(Class<?> type) {

        try {
            Class t = ClassWrapper.wrap(type).getPrimitiveWrapClass();
            return t != null;
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 使用 JDK Proxy动态生成某类接口的代理类
     */
    @SuppressWarnings("unchecked")
    public static <T> T newProxyByJdk(InvocationHandler invocationHandler, Class<?>... interfaces) {

        return (T) Proxy.newProxyInstance(Reflections.class.getClassLoader(), interfaces,
                invocationHandler);
    }

    /**
     * 使用CGLIB动态生成某类接口的代理类
     *
     * @param ih
     * @param interfaces
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T newProxyByCglib(net.sf.cglib.proxy.InvocationHandler ih,
                                        Class<?>... interfaces) {

        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(interfaces);
        enhancer.setCallback(ih);
        return (T) enhancer.create();
    }

    public static void main(String[] args) throws SecurityException, NoSuchMethodException {

//        net.sf.cglib.proxy.InvocationHandler iih = new net.sf.cglib.proxy.InvocationHandler() {
//
//            public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
//
//                Lang.println(arg0 instanceof A);
//                String name = method.getName();
//                if (name.equals("go")) {
//                    return String.format("[%s][CGLIB]I'm going to school...", arg0.getClass());
//                }
//                if (name.equals("hello")) {
//                    return String.format("[%s][CGLIB]Hello,This is not realy hello method.", arg0
//                            .getClass());
//                }
//                return null;
//            }
//
//        };
//        A a = newProxyByCglib(iih, A.class);
//        Lang.println(a.go());
//        Lang.println(a.hello());
//    	String d = "19230121";
//    	Object o = Converts.convert(d, java.util.Date.class);
//    	Lang.println(o);
    }

    public interface A {

        String go();

        String hello();
    }

    /**
     * 将_转化成大写
     *
     * @param fieldName
     * @return
     */
    public static String parseFieldName(String fieldName) {

        if (fieldName != null) {
            Pattern pattern = Pattern.compile("_\\S{1}", Pattern.CASE_INSENSITIVE);
            Matcher match = pattern.matcher(fieldName);
            StringBuffer sb = new StringBuffer("");
            while (match.find()) {
                match.appendReplacement(sb, match.group().replace("_", "").toUpperCase());
            }
            match.appendTail(sb);
            return sb.toString();
        } else {
            return fieldName;
        }
    }

    public static String restoreFieldName(String fieldName) {

        if (fieldName != null) {
            Pattern pattern = Pattern.compile("[A-Z]{1}");
            Matcher match = pattern.matcher(fieldName);
            StringBuffer sb = new StringBuffer("");
            while (match.find()) {
                match.appendReplacement(sb, "_" + match.group());
            }
            match.appendTail(sb);
            // System.out.println(sb);
            return sb.toString();
        } else {
            return fieldName;
        }
    };
}
