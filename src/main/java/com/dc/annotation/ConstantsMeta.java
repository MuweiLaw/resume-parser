package com.dc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD,ElementType.TYPE})
public @interface ConstantsMeta {
	
	/**
	 * 字段描述
	 * @return
	 */
	String comment() default "";
	/**
	 * 所属分类
	 * @return
	 */
	String group() default "";
	
	/**
	 * 是否在使用(Y正在使用 N没有使用) 
	 * @return
	 */
	String isUsed() default "Y";
	
	/**
	 * 父节点编号
	 * @return
	 */
	String parentId() default "";
	
	
	/**
	 * 字典名称
	 * @return
	 */
	String name() default "";
	
	
}
