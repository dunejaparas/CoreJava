package com.pd.core.prepare.lang;

public class ThrowError {

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
	throw new Error(); /* Line 22 */
    }
}
