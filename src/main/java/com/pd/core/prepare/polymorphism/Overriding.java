package com.pd.core.prepare.polymorphism;

public class Overriding {
    public static void main(final String args[]) {
	final Sub sub = new Sub();
	final Base base = new Base();


	System.out.println(sub.hello() + " sub.i " + sub.i);
	System.out.println(base.hello() + " base.i " + base.i);
	final Base basePoly = new Sub();
	System.out.println(basePoly.hello() + " basePoly.i " + basePoly.i);
	final Base basePolyCast = new Sub();
	System.out.println(basePolyCast.hello() + " basePolyCast.i " + basePolyCast.i);

	Sub newSub = new Sub();
	newSub = (Sub) base;
	System.out.println(newSub.hello() + " newSub.i " + newSub.i);

    }

}

class Base {

    int i = 10;

    public String hello() {
	return ("hello A");
    }
}

class Sub extends Base {

    int i = 100;

    @Override
    public String hello() {
	return ("hello B");
    }
}
