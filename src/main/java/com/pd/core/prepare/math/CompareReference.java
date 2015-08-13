package com.pd.core.prepare.math;

public class CompareReference {
    public static void main(final String[] args) {
	final float f = 42.0f;
	final float[] f1 = new float[2];
	final float[] f2 = new float[2];
	final float[] f3 = f1;
	final long x = 42;
	f1[0] = 42.0f;

	System.out.println("f1 == f2 " + (f1 == f2));
	System.out.println("f1 == f3 " + (f1 == f3));
	System.out.println("f2 == f1[1] ");// + (f2 == f1[1]));
	System.out.println("x == f1[0] " + (x == f1[0]));
	System.out.println("f == f1[0] " + (f == f1[0]));
    }
}