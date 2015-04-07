package com.pd.core.patterns.creational.factory;

public class PC extends Computer {

    private final String ram;
    private final String hdd;
    private final String cpu;

    public PC(final String ram, final String hdd, final String cpu) {
	this.ram = ram;
	this.hdd = hdd;
	this.cpu = cpu;
    }

    @Override
    public String getRAM() {
	return this.ram;
    }

    @Override
    public String getHDD() {
	return this.hdd;
    }

    @Override
    public String getCPU() {
	return this.cpu;
    }

}