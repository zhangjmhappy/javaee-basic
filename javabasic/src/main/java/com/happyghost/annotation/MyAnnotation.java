package com.happyghost.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {

    String value() default "默认的构造方法";

    Class type() default void.class;


}
