package com.pd.core.patterns.behavioral.chainofresponsibility.example.currency;

public class Dollar10Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(final DispenseChain nextChain) {
	this.chain = nextChain;
    }

    @Override
    public void dispense(final Currency cur) {
	if (cur.getAmount() >= 20) {
	    final int num = cur.getAmount() / 20;
	    final int remainder = cur.getAmount() % 20;
	    System.out.println("Dispensing " + num + " 20$ note");
	    if (remainder != 0) {
		this.chain.dispense(new Currency(remainder));
	    }
	} else {
	    this.chain.dispense(cur);
	}
    }

}