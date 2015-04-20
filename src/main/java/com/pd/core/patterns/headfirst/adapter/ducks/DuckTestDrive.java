package com.pd.core.patterns.headfirst.adapter.ducks;

public class DuckTestDrive {
    public static void main(final String[] args) {
	final MallardDuck duck = new MallardDuck();

	final WildTurkey turkey = new WildTurkey();
	final Duck turkeyAdapter = new TurkeyAdapter(turkey);

	System.out.println("The Turkey says...");
	turkey.gobble();
	turkey.fly();

	System.out.println("\nThe Duck says...");
	testDuck(duck);

	System.out.println("\nThe TurkeyAdapter says...");
	testDuck(turkeyAdapter);
    }

    static void testDuck(final Duck duck) {
	duck.quack();
	duck.fly();
    }
}
