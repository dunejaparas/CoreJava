package com.pd.core.prepare.string;

public class SubString1 {

    public static void main(final String[] args) {
	String a = "newspaper";
	a = a.substring(5, 7);
	final char b = a.charAt(1);
	a = a + b;
	System.out.println(a);
    }
}
