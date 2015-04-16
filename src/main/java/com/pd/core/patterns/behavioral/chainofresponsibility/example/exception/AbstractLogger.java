package com.pd.core.patterns.behavioral.chainofresponsibility.example.exception;

public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    // next element in chain or responsibility
    protected AbstractLogger nextLogger;

    public void setNextLogger(final AbstractLogger nextLogger) {
	this.nextLogger = nextLogger;
    }

    public void logMessage(final int level, final String message) {
	if (this.level <= level) {
	    write(message);
	}
	if (nextLogger != null) {
	    nextLogger.logMessage(level, message);
	}
    }

    abstract protected void write(String message);

}