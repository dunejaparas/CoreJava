package com.pd.core.patterns.behavioral.chainofresponsibility.example.currency;

/**
 *
 * We need to create different processor classes that will implement the
 * DispenseChain interface and provide implementation of dispense methods. Since
 * we are developing our system to work with three types of currency bills –
 * 50$, 20$ and 10$, we will create three concrete implementations.
 *
 *
 *
 */
public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(final DispenseChain nextChain) {
	this.chain = nextChain;
    }

    @Override
    public void dispense(final Currency cur) {
	if (cur.getAmount() >= 50) {
	    final int num = cur.getAmount() / 50;
	    final int remainder = cur.getAmount() % 50;
	    System.out.println("Dispensing " + num + " 50$ note");
	    if (remainder != 0) {
		this.chain.dispense(new Currency(remainder));
	    }
	} else {
	    this.chain.dispense(cur);
	}
    }

}