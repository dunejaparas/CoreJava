package com.pd.core.customannotations.demo;

import com.pd.core.customannotations.*;

public class InheritanceExample {

    private static final String IS_TRUE = "is true: ";

    public static void main(final String[] args) {
	System.out.println(IS_TRUE
		+ AnnotatedSuperClass.class
			.isAnnotationPresent(InheritedAnnotation.class));

	System.out.println(IS_TRUE
		+ AnnotatedSubClass.class
			.isAnnotationPresent(InheritedAnnotation.class));

	System.out.println(IS_TRUE
		+ AnnotatedInterface.class
			.isAnnotationPresent(InheritedAnnotation.class));

	System.out.println(IS_TRUE
		+ AnnotatedImplementedClass.class
			.isAnnotationPresent(InheritedAnnotation.class));
    }
}
// whats this new issue
