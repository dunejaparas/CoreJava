package com.pd.core.prepare.output;

class Bitwise {
    public static void main(final String[] args) {
	final int x = 11 & 9;
	final int y = x ^ 3;
	System.out.println(y | 12);
    }
}