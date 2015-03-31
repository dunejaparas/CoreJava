package com.pd.core.log4j;

import org.apache.log4j.Logger;

public class MyLog4jExample {

    private final Logger logger;

    public MyLog4jExample() {
	logger = Logger.getLogger("My component logger");
    }

    public static void main(final String args[]) {
	new MyLog4jExample().start();
    }

    private void start() {
	logger.debug("PARAS");

    }

}
