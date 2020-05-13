package com.dc.framework.lang.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dc.framework.lang.Lang;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 扩展Apache Commons BeanUtils(主要用于对java对象的属性获取与设置), 提供一些扩展.
 */
public abstract class Beans extends BeanUtils {
    
    protected static final Log logger = LogFactory.getLog(Beans.class);
    
    /**
     * 设置某个bean的属性值
     * 
     * @param o 要设置属性值的对象
     * @param p 属性名
     * @param v 属性值
     */
    public static void setProperty(Object o, String p, Object v) {

        try {
            BeanUtils.setProperty(o, p, v);
        } catch (Exception e) {
            throw Lang.wrapThrow(e, "设置对象(类型：%s)属性\"%s\"时出错了！！", o.getClass().getName(), p);
        }
    }
    
    /**
     * 根据map值设置bean的属性
     *  @param bean
     * @param properties
     */
    public static void populate(Object bean, Map<String, ? extends Object> properties) {

        try {
            BeanUtils.populate(bean, properties);
        } catch (Exception e) {
            throw Lang.wrapThrow(e, "根据Map[%s]设置对象[%s]的值出错了！！", properties, bean.getClass()
                    .getName());
        }
    }
    
    /**
     * 根据map值设置bean的属性
     *
     * @param <T>
     * @param t
     * @param properties
     * @return
     */
    public static <T> T setProperties(T t, Map<?,  ? extends Object> properties) {

        populate(t, (Map<String, ? extends Object>) properties);
        return t;
    }

    /**
     * 根据指定类型生成一个新的对象，并根据提供的map值设置其属性值
     * 
     * @param <T>
     * @param type
     * @param properties
     * @return
     */
    public static <T> T of(Class<T> type, Map<?, ?> properties) {

        T t = ClassWrapper.wrap(type).newOne();
        t = setProperties(t, properties);
        return t;
    }
    
    /**
     * 将JavaBean转换成Map
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map beanToMap(Object bean) {

        Map map = new HashMap();
        Field[] fields = bean.getClass().getDeclaredFields();
        BeanMap beanMap = new BeanMap(bean);
        Set set = beanMap.keySet();
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            for (Field field : fields) {
                if (field.getName().equals(key)) {
                    Object value = beanMap.get(key);
                    if (value == null || value instanceof Integer || value instanceof String
                            || value instanceof Date || value instanceof Double
                            || value instanceof BigDecimal || value instanceof Character
                            || value instanceof Boolean || value instanceof Float
                            || value instanceof Short || value instanceof Long
                            || value instanceof Byte) {
                        map.put(key, value != null ? value : "");
                    }
                    break;
                }
            }
        }
        return map;
    }
    
    /**
     * 将bean的fieldName转化成in
     * 
     * @param list
     * @param fieldName
     * @return
     */
    public static String convertListToIn(List list, String fieldName) {

        StringBuffer sb = new StringBuffer("(");
        String methodName = "getId";
        if (fieldName != null) {
            methodName = "get" + (fieldName.charAt(0) + "").toUpperCase() + fieldName.substring(1);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append("'").append(getFieldValue(list.get(i), methodName)).append("',");
        }
        sb.append("'").append(
                list.size() > 0 ? getFieldValue(list.get(list.size() - 1), methodName) : "")
                .append("'");
        sb.append(")");
        return sb.toString();
    }
    
    public static String getFieldValue(Object obj, String methodName) {

        String value = "";
        try {
            value = (String) obj.getClass().getMethod(methodName).invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    
    /**
     * 
     * 取值属性值，如果对象没有相应的属性，则制造对应的方法，不一定需要get,或is开头
     * 
     * @param obj
     * @param propertyExpression beanutils的表达式
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Object getAnyProperty(final Object obj, String propertyExpression) {

        if (obj == null || propertyExpression == null || propertyExpression.trim().length() < 1) {
            
            return null;
        }
        
        String[] names = propertyExpression.split("\\.");
        
        Object result = obj;
        Object temp = null;
        
        for (int i = 0; i < names.length; i++) {
            
            Matcher m = itratorPtn.matcher(names[i]);
            String propertyName = null;
            
            if (m.find()) {
                propertyName = m.group(1);
                names[i] = names[i].substring(0, names[i].indexOf("["));
            }
            
            if (temp != null) {
                result = temp;
                temp = null;
            } else {
                result = Beans.getSimpleValue(result, names[i]);
            }
            
            if (result == null) {
                // 如果是空值则退出
                break;
            }
            
            if ((result instanceof Collection)) {
                // 如果是集合
                // log.debug(" result is a Collection");
                Collection c = (Collection) result;
                c.size();// 初始化
                
                if (propertyName != null) {
                    for (Iterator iterator = c.iterator(); iterator.hasNext();) {
                        Beans.getSimpleValue(iterator.next(), propertyName);
                    }
                }
            } else if (result instanceof Map) {
                
                // 如果是Map
                // log.debug(" result is a Map");
                Map map = (Map) result;
                map.size();
                
                if (propertyName != null) {
                    for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {
                        Beans.getSimpleValue(iterator.next(), propertyName);
                    }
                }
                
                temp = map.get(names[i]);
            } else if (result.getClass().isArray()) {
                
                // 如果数组
                try {
                    temp = Array.get(result, Integer.parseInt(names[i]));
                } catch (Exception e) {
                    Lang.wrapThrow(e, "get array property from [%s]", obj.getClass()
                            .getSimpleName());
                    // log.debug("get arrary[" + names[i] + "] error,", e);
                }
            }
        }
        
        return result;
    }
    
    /**
     * 获取某个对象的getter属性值
     * @param obj 对象 
     * @param property 属性
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Object getSimpleValue(Object obj, String property) {

        Object result = null;
        try {
            
            result = PropertyUtils.getSimpleProperty(obj, property);
        } catch (Throwable e) {
            try {
                result = MethodUtils.invokeExactMethod(obj, property, new Object[] {});
            } catch (Throwable ex) {
                try {
                    Field field = obj.getClass().getField(property);
                    boolean p = field.isAccessible();
                    field.setAccessible(true);
                    result = field.get(obj);
                    field.setAccessible(p);
                } catch (Exception exx) {
                    Lang.wrapThrow(exx, "getField %s.%s error!", obj.getClass().getSimpleName(),
                            property);
                }
            }
        }
        
        // 最后如果是集，则初始化
        if ((result instanceof Collection)) {
            // 如果是集合}
            Collection c = (Collection) result;
            c.size();// 初始化
        } else if (result instanceof Map) {
            // 如果是Map
            Map map = (Map) result;
            map.size();
        } else if (result != null) {
            result.toString();//
        }
        return result;
    }
    
    // 集合
    public static Pattern itratorPtn = Pattern.compile("\\[(\\w+)\\]");
    
}
