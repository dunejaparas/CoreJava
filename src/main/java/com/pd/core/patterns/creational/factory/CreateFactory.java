package com.pd.core.patterns.creational.factory;

import org.apache.log4j.Logger;

public class CreateFactory {

    Logger logger = Logger.getLogger(this.getClass().getName());

    public static void main(final String[] args) {
	new CreateFactory().begin();
    }

    // Note use of enum singleton pattern
    private void begin() {

	final Computer pc = ComputerFactory.INSTANCE.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
	final Computer server = ComputerFactory.INSTANCE.getComputer("server", "16 GB", "1 TB", "2.9 GHz");

	logger.info("Factory PC Config::" + pc);
	logger.info("Factory Server Config::" + server);
    }

}