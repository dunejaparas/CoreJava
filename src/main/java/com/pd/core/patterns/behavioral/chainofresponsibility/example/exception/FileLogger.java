package com.pd.core.patterns.behavioral.chainofresponsibility.example.exception;

public class FileLogger extends AbstractLogger {

    public FileLogger(final int level) {
	this.level = level;
    }

    @Override
    protected void write(final String message) {
	System.out.println("File::Logger: " + message);
    }
}