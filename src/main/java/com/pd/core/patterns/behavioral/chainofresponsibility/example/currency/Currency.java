package com.pd.core.patterns.behavioral.chainofresponsibility.example.currency;

/**
 * We can create a class Currency that will store the amount to dispense and
 * used by the chain implementations.
 */
public class Currency {

    private final int amount;

    public Currency(final int amt) {
	this.amount = amt;
    }

    public int getAmount() {
	return this.amount;
    }
}