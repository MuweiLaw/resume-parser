package com.dc.framework.orm.id;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于默认设置ID的值，默认为字符串类型。
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.TYPE, ElementType.FIELD })
public @interface ID {
    
    /**
     * 要生成的ID类型，如'UUID'
     * 
     * @return
     */
    GenType genType() default GenType.UUID;
    
    /**
     * ID名字，如果是注释在类的话必须指定哪个字段为ID
     * 
     * @return
     */
    String value() default "";
    
}
