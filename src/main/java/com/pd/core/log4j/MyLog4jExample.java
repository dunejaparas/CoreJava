package com.pd.core.log4j;

import org.apache.log4j.Logger;

public class MyLog4jExample {

    private final Logger logger;

    public MyLog4jExample() {
	logger = Logger.getLogger(this.getClass().getName());
    }

    public static void main(final String args[]) {
	new MyLog4jExample().start();
    }

    private void start() {
	logger.debug("Hello this is an debug message");
	logger.info("Hello this is an info message");
    }

}
