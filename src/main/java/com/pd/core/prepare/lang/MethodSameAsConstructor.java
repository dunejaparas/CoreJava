package com.pd.core.prepare.lang;

public class MethodSameAsConstructor {

    MethodSameAsConstructor() {
	System.out.println("Constructor");
    }

    void MethodSameAsConstructor() {
	System.out.println("Method");
    }

    public static void main(final String[] args) {
	new MethodSameAsConstructor();
    }
}