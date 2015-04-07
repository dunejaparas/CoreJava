package com.pd.core.patterns.creational.factory;

public enum ComputerFactory {

    INSTANCE;

    public Computer getComputer(final String type, final String ram, final String hdd, final String cpu) {
	if ("PC".equalsIgnoreCase(type)) {
	    return new PC(ram, hdd, cpu);
	} else if ("Server".equalsIgnoreCase(type)) {
	    return new Server(ram, hdd, cpu);
	}

	return null;
    }

}
