package com.pd.core.patterns.behavioral.chainofresponsibility.example.exception;

/**
 * Create different types of loggers. Assign them error levels and set next
 * logger in each logger. Next logger in each logger represents the part of the
 * chain.
 *
 */
public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers() {

	final AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
	final AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
	final AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

	errorLogger.setNextLogger(fileLogger);
	fileLogger.setNextLogger(consoleLogger);

	return errorLogger;
    }

    public static void main(final String[] args) {
	final AbstractLogger loggerChain = getChainOfLoggers();

	loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
	System.out.println();
	loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
	System.out.println();
	loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}
