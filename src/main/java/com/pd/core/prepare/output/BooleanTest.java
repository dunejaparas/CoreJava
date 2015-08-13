package com.pd.core.prepare.output;

public class BooleanTest {

    public static void main(final String[] args) {
	final BooleanTest p = new BooleanTest();
	p.start();
    }

    void start() {
	final boolean b1 = false;
	final boolean b2 = fix(b1);
	System.out.println(b1 + " " + b2);
    }

    boolean fix(boolean b1) {
	b1 = true;
	return b1;
    }
}