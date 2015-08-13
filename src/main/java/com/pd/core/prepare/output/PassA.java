package com.pd.core.prepare.output;

public class PassA {
    public static void main(final String[] args) {
	final PassA p = new PassA();
	p.start();
    }

    void start()
    {
	final long[] a1 = { 3, 4, 5 };
	final long[] a2 = fix(a1);
	System.out.print(a1[0] + a1[1] + a1[2] + " ");
	System.out.println(a2[0] + a2[1] + a2[2]);
    }

    long[] fix(final long[] a3) {
	a3[1] = 7;
	return a3;
    }
}