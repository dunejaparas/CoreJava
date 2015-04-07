package com.pd.core.patterns.creational.abstractfactory;

import com.pd.core.patterns.creational.factory.Computer;

public class ComputerFactory {
    public static Computer getComputer(final IComputerAbstractFactory factory) {
	return factory.createComputer();
    }
}
