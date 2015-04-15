package com.pd.core.patterns.structural.bridge.example.shapeandcolors;

/**
 * 
 * Bridge design pattern can be used when both abstraction and implementation
 * can have different hierarchies independently and we want to hide the
 * implementation from the client application.
 *
 */
public class BridgePatternDemo {
    public static void main(final String[] args) {
	final Shape tri = new Triangle(new RedColor());
	tri.applyColor();

	final Shape pent = new Pentagon(new GreenColor());
	pent.applyColor();
    }
}
