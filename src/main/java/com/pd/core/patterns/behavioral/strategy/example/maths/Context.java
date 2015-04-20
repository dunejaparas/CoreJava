package com.pd.core.patterns.behavioral.strategy.example.maths;

public class Context {
    private final IStrategy strategy;

    public Context(final IStrategy strategy) {
	this.strategy = strategy;
    }

    public int executeStrategy(final int num1, final int num2) {
	return strategy.doOperation(num1, num2);
    }
}
