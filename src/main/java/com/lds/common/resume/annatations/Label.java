package com.lds.common.resume.annatations;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Label {

    String[] keys() default "";

    int length() default 0;

}