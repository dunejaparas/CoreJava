package com.pd.core.prepare.output;

public class PassS {
    public static void main(final String[] args) {
	final PassS p = new PassS();
	p.start();
    }

    void start() {
	final String s1 = "slip";
	final String s2 = fix(s1);
	System.out.println(s1 + " " + s2);
    }

    String fix(String s1) {
	s1 = s1 + "stream";
	System.out.print(s1 + " ");
	return "stream";
    }
}
