package com.pd.core.prepare.output;

public class BasicLoop {

    private static float[] f = new float[2];

    public static void main(final String[] args) {
	int I = 0;
	outer: while (true) {
	    I++;
	    inner: for (int j = 0; j < 10; j++) {
		I += j;
		if (j == 3) {
		    continue inner;
		}
		break outer;
	    }
	    continue outer;
	}
	System.out.println(I);

	System.out.println("f[0] = " + f[0]);

    }

}
