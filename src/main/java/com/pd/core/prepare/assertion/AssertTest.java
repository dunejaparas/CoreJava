package com.pd.core.prepare.assertion;

public class AssertTest {


    public static int y;

    public static void foo(final int x) {
	System.out.print("foo ");
	y = x;
    }

    public static int bar(final int z) {
	System.out.print("bar ");
	return y = z;
    }

    public static void main(final String[] args) {
	final int t = 0;
	assert t > 0 : bar(7);
	// assert t > 1 : foo(8); /* Line 18 */
	System.out.println("done ");
    }
}
