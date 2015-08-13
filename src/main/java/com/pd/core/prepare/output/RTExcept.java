package com.pd.core.prepare.output;

public class RTExcept {
    public static void throwit() {
	System.out.print("throwit ");
	throw new RuntimeException();
    }

    public static void main(final String[] args) {
	try {
	    System.out.print("hello ");
	    throwit();
	} catch (final Exception re) {
	    System.out.print("caught ");
	} finally {
	    System.out.print("finally ");
	}
	System.out.println("after ");

	main();
    }

    public static void main() {
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
    }
}