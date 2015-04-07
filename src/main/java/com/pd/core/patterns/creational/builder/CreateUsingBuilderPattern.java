package com.pd.core.patterns.creational.builder;

public class CreateUsingBuilderPattern {
    public static void main(final String[] args) {
	// Using builder to get the object in a single line of code and
	// without any inconsistent state or arguments management issues
	final Computer comp = new Computer.ComputerBuilder("500 GB", "2 GB").setBluetoothEnabled(true)
		.setGraphicsCardEnabled(true).build();

	System.out.println("CreateUsingBuilderPattern comp:" + comp);

	/**
	 * Builder Design Pattern Example in JDK
	 * 
	 * java.lang.StringBuilder#append() (unsynchronized)
	 * java.lang.StringBuffer#append() (synchronized)
	 */
    }
}
