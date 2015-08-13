package com.pd.core.prepare.output;

public class Test178 {
    public static void main(final String[] args) {
	final String s = "foo";
	final Object o = s;
	System.out.println(o instanceof String);
	if (s.equals(o)) {
	    System.out.print("AAA");
	} else {
	    System.out.print("BBB");
	}
	if (o.equals(s)) {
	    System.out.print("CCC");
	} else {
	    System.out.print("DDD");
	}
	new DDD();
    }
}

class DDD {
    public DDD() {
	System.out.println("cons");
    }
}