package com.dc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD,ElementType.TYPE})
public @interface DomainMeta {
	/**
	 * 字段描述
	 * @return
	 */
	String description() default "";
	/**
	 * 表字段名称
	 * @return
	 */
	String tableField() default "";
	/**
	 * 表名
	 * @return
	 */
	String tableName() default "";
	/**
	 * 表字段类型
	 * @return
	 */
	String jdbcType() default"";
	/**
	 * 表字段长度
	 * @return
	 */
	int jdbcLength() default 0;
	/**
	 * 表字段是否非空
	 * @return
	 */
	boolean notNull() default false;
	
	/**
	 * 是否是主键
	 * @return
	 */
	boolean isPrimaryKey() default false;
	
	/**
	 * 是否是表字段
	 * @return
	 */
	boolean notTableField() default false;
	
	/**
	 * 一般索引
	 * @return
	 */
	String[] keys() default {};
	
	/**
	 * 唯一索引
	 * @return
	 */
	String[] uqKeys() default {};
	
	/**
	 * 字段排序
	 */
	int order() default 1;
}
