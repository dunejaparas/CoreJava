package com.pd.core.prepare.lang;

public class DefaultBeforeLastInSwitch {
    public static void main(final String args[]) {
	final int i = 1;
	int j = 0;
	switch (i) {
	    case 2:
		j += 6;
	    case 4:
		j += 1;
	    default:
		j += 2;
	    case 0:
		j += 4;
	}
	System.out.println("j = " + j);
    }
}
