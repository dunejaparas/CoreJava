package com.pd.core.patterns.creational.abstractfactory;

import com.pd.core.patterns.creational.factory.Computer;

public class CreateUsingAbstractFactory {

    public static void main(final String[] args) {
	new CreateUsingAbstractFactory().begin();
    }

    private void begin() {
	final Computer pc = ComputerFactory.getComputer(new PCFactoryImpl("2 GB", "500 GB", "2.4 GHz"));
	final Computer server = ComputerFactory.getComputer(new ServerFactoryImpl("16 GB", "1 TB", "2.9 GHz"));
	final Computer tablet = ComputerFactory.getComputer(new TabletFactoryImpl("16 GB", "1 TB", "2.9 GHz"));
	System.out.println("AbstractFactory PC Config::" + pc);
	System.out.println("AbstractFactory Server Config::" + server);
	System.out.println("AbstractFactory tablet Config::" + tablet);
    }
}
