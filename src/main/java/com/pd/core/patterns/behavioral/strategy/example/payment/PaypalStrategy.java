package com.pd.core.patterns.behavioral.strategy.example.payment;

/**
 *
 * Now we will have to create concrete implementations of algorithms for payment
 * using credit/debit card or through paypal.
 *
 *
 *
 */
public class PaypalStrategy implements PaymentStrategy {

    private final String emailId;
    private final String password;

    public PaypalStrategy(final String email, final String pwd) {
	this.emailId = email;
	this.password = pwd;
    }

    @Override
    public void pay(final int amount) {
	System.out.println(amount + " paid using Paypal.");
    }

}
/**
 * Now our algorithms are ready and we can implement Shopping Cart and payment
 * method will require input as Payment strategy.
 */
