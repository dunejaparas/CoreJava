package com.pd.core.patterns.behavioral.strategy.example.payment;

/**
 * First of all we will create the interface for our strategy, in our case to
 * pay the amount passed as argument.
 */
public interface PaymentStrategy {

    public void pay(int amount);
}