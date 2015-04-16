package com.pd.core.patterns.behavioral.chainofresponsibility.example.currency;

public class Dollar20Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(final DispenseChain nextChain) {
	this.chain = nextChain;
    }

    @Override
    public void dispense(final Currency cur) {
	if (cur.getAmount() >= 10) {
	    final int num = cur.getAmount() / 10;
	    final int remainder = cur.getAmount() % 10;
	    System.out.println("Dispensing " + num + " 10$ note");
	    if (remainder != 0) {
		this.chain.dispense(new Currency(remainder));
	    }
	} else {
	    this.chain.dispense(cur);
	}
    }

}
/**
 * The important point to note here is the implementation of dispense method,
 * you will notice that every implementation is trying to process the request
 * and based on the amount, it might process some or full part of it. If it’s
 * not able to process it fully, it sends the request to the next processor in
 * chain to process the remaining request. If the processor is not able to
 * process anything, it just forwards the same request to the next chain.
 */
