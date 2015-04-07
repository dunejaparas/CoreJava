package com.pd.core.patterns.creational.abstractfactory;

import com.pd.core.patterns.creational.factory.Computer;
import com.pd.core.patterns.creational.factory.Server;

public class TabletFactoryImpl implements IComputerAbstractFactory {

    private final String ram;
    private final String hdd;
    private final String cpu;

    public TabletFactoryImpl(final String ram, final String hdd, final String cpu) {
	this.ram = ram;
	this.hdd = hdd;
	this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
	return new Server(ram, hdd, cpu);
    }

}