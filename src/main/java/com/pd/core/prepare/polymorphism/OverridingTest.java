package com.pd.core.prepare.polymorphism;

public class OverridingTest {
	public static void main(final String args[]) {
		final Base1 base = new Sub1();
		base.printIt();
		base.printIt(false);
	}

}

class Base1 {

	public void printIt() {
		System.out.println("Base1");
	}

	public void printIt(final boolean value) {
		if (value) {
			System.out.println("Base 2");
		} else {
			printIt();
		}
	}
}

class Sub1 extends Base1 {

	@Override
	public void printIt() {
		System.out.println("Sub1");
	}
}
