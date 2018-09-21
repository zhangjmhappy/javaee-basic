package com.happyghost.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorAnnotation {

    //作者姓名
    String name();

    /***
     * 公司
     *
     * */
    String compnay();
}
