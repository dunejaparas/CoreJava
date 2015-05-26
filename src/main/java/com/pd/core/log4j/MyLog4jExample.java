package com.pd.core.log4j;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class MyLog4jExample {

    private final Logger logger;
    private static final SimpleDateFormat formatter = new SimpleDateFormat(
	    "yyyy-MM-dd_HH-mm-ss_SSS");

    public MyLog4jExample() {
	logger = Logger.getLogger(this.getClass().getName());

	logger.info("class.getName()" + this.getClass().getName());
	logger.info("class.getCanonicalName()" + this.getClass().getCanonicalName());
	logger.info("class.getSimpleName()" + this.getClass().getSimpleName());
    }

    public static void main(final String args[]) {
	new MyLog4jExample().start();
    }

    private void start() {

	final Date start = new Date();
	logger.info("Modified : " + formatter.format(start));

	/*
	 * The guard statement (checking isDebugEnabled()) is there to prevent
	 * potentially expensive computation of the log message when it involves
	 * invocation of the toString() methods of various objects and
	 * concatenating the results.
	 */
	if (logger.isDebugEnabled()) {
	    logger.debug("Hello this is an debug message");
	}

	logger.info("Hello this is an info message");

	try {
	    throw new ArithmeticException("Divison");
	} catch (final ArithmeticException ae) {
	    logger.error("ArithmeticException caused by " + ae.getMessage(), ae);
	}

	final Date end = new Date();
	logger.info("Modified : " + formatter.format(end));

	final long diff = end.getTime() - start.getTime();
	final long diffSeconds = diff / 1000 % 60;
	logger.info("Modified diff in seconds : " + diffSeconds);
    }
}
