package com.pd.core.patterns.behavioral.chainofresponsibility.example.exception;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(final int level) {
	this.level = level;
    }

    @Override
    protected void write(final String message) {
	System.out.println("Error Console::Logger: " + message);
    }
}
