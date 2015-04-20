package com.pd.core.patterns.behavioral.strategy.example.maths;

/**
 * Create concrete classes implementing the same interface.
 */
public class OperationSubstract implements IStrategy {
    @Override
    public int doOperation(final int num1, final int num2) {
	return num1 - num2;
    }
}
