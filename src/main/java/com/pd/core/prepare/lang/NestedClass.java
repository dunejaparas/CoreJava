package com.pd.core.prepare.lang;


public class NestedClass {
    NestedClass() {
	System.out.print("foo");
    }

    class Bar {
	Bar() {
	    System.out.print("bar");
	}

	public void go() {
	    System.out.print("hi");
	}
    } /* class Bar ends */

    public static void main(final String[] args) {
	final NestedClass f = new NestedClass();
	f.makeBar();
    }

    void makeBar() {
	(new Bar() {
	}).go();
	// (new Bar()).go();
    }
}/* class Foo ends */
