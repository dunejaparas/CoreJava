package com.pd.core.patterns.creational.builder;

// Notice that Computer class has only getter methods and no public constructor, so the only way to get a Computer object is through the ComputerBuilder class.
public class Computer {

    // required parameters
    private final String HDD;
    private final String RAM;

    // optional parameters
    private final boolean isGraphicsCardEnabled;
    private final boolean isBluetoothEnabled;

    public String getHDD() {
	return HDD;
    }

    public String getRAM() {
	return RAM;
    }

    public boolean isGraphicsCardEnabled() {
	return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
	return isBluetoothEnabled;
    }

    private Computer(final ComputerBuilder builder) {
	this.HDD = builder.HDD;
	this.RAM = builder.RAM;
	this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
	this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Builder Class
    public static class ComputerBuilder {

	// required parameters
	private final String HDD;
	private final String RAM;

	// optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	public ComputerBuilder(final String hdd, final String ram) {
	    this.HDD = hdd;
	    this.RAM = ram;
	}

	public ComputerBuilder setGraphicsCardEnabled(final boolean isGraphicsCardEnabled) {
	    this.isGraphicsCardEnabled = isGraphicsCardEnabled;
	    return this;
	}

	public ComputerBuilder setBluetoothEnabled(final boolean isBluetoothEnabled) {
	    this.isBluetoothEnabled = isBluetoothEnabled;
	    return this;
	}

	public Computer build() {
	    return new Computer(this);
	}

    }

}