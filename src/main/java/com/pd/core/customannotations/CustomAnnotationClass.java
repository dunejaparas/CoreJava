package com.pd.core.customannotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomAnnotationClass {

    public String author() default "CustomAnnotationClass";

    public String date();

    String getInfo() default "CustomAnnotationClass.Info";

}
