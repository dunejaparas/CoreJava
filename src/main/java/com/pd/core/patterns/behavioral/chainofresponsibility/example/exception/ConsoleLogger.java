package com.pd.core.patterns.behavioral.chainofresponsibility.example.exception;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(final int level) {
	this.level = level;
    }

    @Override
    protected void write(final String message) {
	System.out.println("Standard Console::Logger: " + message);
    }
}