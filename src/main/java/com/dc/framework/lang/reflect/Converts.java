package com.dc.framework.lang.reflect;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

/**
 * @version 1.0.0
 * @className Converts
 * @description 类型转换器注册、获取与执行
 * @date 2019/12/13 16:15
 */
public class Converts {

    @SuppressWarnings("unchecked")
    public static <T> T convert(Object src, Class<T> toClass) {

        T toObject = (T) ConvertUtils.convert(src, toClass);
        return toObject;
    }

    @SuppressWarnings("unchecked")
    public static void addConvert(Converter converter, Class type) {

        ConvertUtils.register(converter, type);
    }

    public static boolean hasConver(Class<?> sourceType, Class<?> targetType) {

        return get(sourceType, targetType) != null;
    }

    public static boolean hasConver(Class<?> targetType) {

        return get(targetType) != null;
    }

    public static Converter get(Class<?> sourceType, Class<?> targetType) {

        return ConvertUtils.lookup(sourceType, targetType);
    }

    public static Converter get(Class<?> targetType) {

        return ConvertUtils.lookup(targetType);
    }
}
