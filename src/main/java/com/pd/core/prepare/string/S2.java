package com.pd.core.prepare.string;

public class S2 {
    public static void main(final String[] args) {
	final S2 s = new S2();
	s.start();
    }

    void start() {
	final int a = 3;
	final int b = 4;
	System.out.print(" " + 7 + 2 + " ");
	System.out.print(a + b);
	System.out.print(" " + a + b + " ");
	System.out.print(foo() + a + b + " ");
	System.out.println(a + b + foo());
    }

    String foo() {
	return "foo";
    }
}