package com.pd.core.patterns.behavioral.strategy.example.payment;

/**
 *
 * Now we will have to create concrete implementations of algorithms for payment
 * using credit/debit card or through paypal.
 *
 *
 *
 */
public class CreditCardStrategy implements PaymentStrategy {

    private final String name;
    private final String cardNumber;
    private final String cvv;
    private final String dateOfExpiry;

    public CreditCardStrategy(final String nm, final String ccNum, final String cvv, final String expiryDate) {
	this.name = nm;
	this.cardNumber = ccNum;
	this.cvv = cvv;
	this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(final int amount) {
	System.out.println(amount + " paid with credit/debit card");
    }
}
/**
 * Now our algorithms are ready and we can implement Shopping Cart and payment
 * method will require input as Payment strategy.
 */
