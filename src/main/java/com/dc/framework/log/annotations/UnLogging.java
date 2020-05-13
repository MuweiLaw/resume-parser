
package com.dc.framework.log.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对不需要记录日志的Class或者Method或添加此注解，日志拦器就不会处理 可在类声明也可以在方法声明，在类声明则要指定value值，即指定哪些方法 名不需要记录日志，定义方法如下：
 * 
 * <pre>
 * 	@UnLogging("方法1,方法2")
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.TYPE, ElementType.METHOD })
public @interface UnLogging {
    
    String value() default "";
}
