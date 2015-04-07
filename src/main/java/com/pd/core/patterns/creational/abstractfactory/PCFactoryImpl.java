package com.pd.core.patterns.creational.abstractfactory;

import com.pd.core.patterns.creational.factory.Computer;
import com.pd.core.patterns.creational.factory.PC;

public class PCFactoryImpl implements IComputerAbstractFactory {

    private final String ram;
    private final String hdd;
    private final String cpu;

    public PCFactoryImpl(final String ram, final String hdd, final String cpu) {
	this.ram = ram;
	this.hdd = hdd;
	this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
	return new PC(ram, hdd, cpu);
    }

}