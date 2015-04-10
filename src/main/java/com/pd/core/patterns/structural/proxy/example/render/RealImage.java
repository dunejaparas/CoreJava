package com.pd.core.patterns.structural.proxy.example.render;

public class RealImage implements Image {

    private final String fileName;

    public RealImage(final String fileName) {
	this.fileName = fileName;
	loadFromDisk(fileName);
    }

    @Override
    public void display() {
	System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(final String fileName) {
	System.out.println("Loading " + fileName);
    }
}