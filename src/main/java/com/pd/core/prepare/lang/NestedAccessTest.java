package com.pd.core.prepare.lang;

public class NestedAccessTest {
    public static void main(final String args[]) {
	class Foo {
	    public int i = 3;
	}
	final Object o = new Foo();
	final Foo foo = (Foo) o;
	System.out.println("i = " + foo.i);
    }
}
