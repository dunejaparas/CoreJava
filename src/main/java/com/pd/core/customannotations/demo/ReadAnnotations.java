package com.pd.core.customannotations.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.pd.core.customannotations.*;

public class ReadAnnotations {

    public static void main(final String[] args) throws Exception {

	final Class<AnnotatedClass> object = AnnotatedClass.class;
	// Retrieve all annotations from the class
	final Annotation[] annotations = object.getAnnotations();
	for (final Annotation annotation : annotations) {
	    System.out.println(annotation);
	}

	// Checks if an annotation is present
	if (object.isAnnotationPresent(CustomAnnotationClass.class)) {

	    // Gets the desired annotation
	    final Annotation annotation = object
		    .getAnnotation(CustomAnnotationClass.class);

	    System.out.println(annotation);

	}
	// the same for all methods of the class
	for (final Method method : object.getDeclaredMethods()) {

	    if (method.isAnnotationPresent(CustomAnnotationMethod.class)) {

		final Annotation annotation = method
			.getAnnotation(CustomAnnotationMethod.class);

		System.out.println(annotation);

	    }

	}
    }
}
