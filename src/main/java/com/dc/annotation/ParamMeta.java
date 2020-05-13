package com.dc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD,ElementType.TYPE})
public @interface ParamMeta {

    /**
     * 注释
     * @return
     */
    String value() default "";
    /**
     * 是否必填
     * @return
     */
    boolean isNecessary() default true;
    /**
     * 对映表字段
     * @return
     */
    String tableField() default "";

    /**
     * 该字段是否不需要生成文档
     * @return
     */
    boolean ignore() default false;

    /**
     * 备注
     * @return
     */
    String comment() default "";

    /**
     * 示例值
     * @return
     */
    String example() default "";

    /**
     * 类型
     * @return
     */
    String pattern() default "";

    /**
     * 默认值
     * @return
     */
    String defaultValue() default "";

    /**
     * 搜索引擎专用（是否属于范围区间）
     * @return
     */
    boolean isRangeType() default false;

    /**
     * 搜索引擎专用（是否属于或条件）
     * @return
     */
    boolean should() default false;

    /**
     * 搜索引擎专用（是否属于非）
     * @return
     */
    boolean mustNot() default false;

    /**
     * 搜索引擎专用（是否使用模糊查询）
     * @return
     */
    boolean like() default false;

    /**
     * 搜索引擎专用（字符串转小写）
     * @return
     */
    boolean toLowerCase() default true;
}
