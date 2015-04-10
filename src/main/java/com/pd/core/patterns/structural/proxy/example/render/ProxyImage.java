package com.pd.core.patterns.structural.proxy.example.render;

public class ProxyImage implements Image {

    private RealImage realImage;
    private final String fileName;

    public ProxyImage(final String fileName) {
	this.fileName = fileName;
    }

    @Override
    public void display() {
	if (realImage == null) {
	    realImage = new RealImage(fileName);
	}
	realImage.display();
    }
}