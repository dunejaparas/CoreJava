package com.pd.core.prepare.lang;

public class ThrowRuntimeException {

    public static void main(final String[] args) {
	try {
	    badMethod();
	    System.out.print("A");
	} catch (final Exception ex) {
	    System.out.print("B");
	} finally {
	    System.out.print("C");
	}
	System.out.print("D");
    }

    public static void badMethod() {
	final Object s;
	throw new RuntimeException(); /* Line 22 */

    }
}
