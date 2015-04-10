package com.pd.core.patterns.structural.proxy.example.render;

public class ProxyPatternDemo {
    public static void main(final String[] args) {
	final Image image = new ProxyImage("test_10mb.jpg");

	// image will be loaded from disk
	image.display();
	System.out.println("");

	// image will not be loaded from disk
	image.display();
    }
}
