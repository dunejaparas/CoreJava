package com.pd.core.customannotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CustomAnnotationMethod {

    public String author() default "CustomAnnotationMethod";

    public String date();

    public String description();

}
