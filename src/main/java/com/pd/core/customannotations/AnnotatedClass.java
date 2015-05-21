package com.pd.core.customannotations;

@CustomAnnotationClass(date = "2015-05-22")
public class AnnotatedClass {

    @CustomAnnotationMethod(date = "2014-06-05", description = "annotated method")
    public String annotatedMethod() {
	return "annotatedMethod";
    }

    @CustomAnnotationMethod(author = "friend of mine", date = "2015-05-22", description = "annotated method")
    public String annotatedMethodFromAFriend() {
	return "annotatedMethodFromAFriend";
    }

}
