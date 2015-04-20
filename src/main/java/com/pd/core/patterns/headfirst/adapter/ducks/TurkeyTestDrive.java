package com.pd.core.patterns.headfirst.adapter.ducks;

public class TurkeyTestDrive {
    public static void main(final String[] args) {
	final MallardDuck duck = new MallardDuck();
	final Turkey duckAdapter = new DuckAdapter(duck);

	for (int i = 0; i < 10; i++) {
	    System.out.println("The DuckAdapter says...");
	    duckAdapter.gobble();
	    duckAdapter.fly();
	}
    }
}
