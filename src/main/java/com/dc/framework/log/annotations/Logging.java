
package com.dc.framework.log.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对于特殊的模块可以自已指定日志记录信息
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.TYPE, ElementType.METHOD })
public @interface Logging {
    /**
     * 日志的敏感级别
     * @return
     */
    String sensitivity() default "";
    
    /**
     * 子系统编码
     * @return
     */
    String systemCode() default "";
    
    /**
     * 模块编码
     * @return
     */
    String moduleCode() default "";
    
    /**
     * 模块名称
     * @return
     */
    String moduleName() default "";
    
    /**
     * 操作类型
     * @return
     */
    String operationType() default "";
    
    /**
     * 操作描述
     * @return
     */
    String operationDesc() default "";
}
