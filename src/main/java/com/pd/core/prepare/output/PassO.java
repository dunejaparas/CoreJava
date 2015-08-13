package com.pd.core.prepare.output;

class Two {
    byte x;
}

public class PassO {
    public static void main(final String[] args) {
	final PassO p = new PassO();
	p.start();
    }

    void start() {
	final Two t = new Two();
	System.out.print(t.x + " ");
	final Two t2 = fix(t);
	System.out.println(t.x + " " + t2.x);
    }

    Two fix(final Two tt) {
	tt.x = 42;
	return tt;
    }
}