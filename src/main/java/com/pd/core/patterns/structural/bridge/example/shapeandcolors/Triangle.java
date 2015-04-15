package com.pd.core.patterns.structural.bridge.example.shapeandcolors;


public class Triangle extends Shape {

    public Triangle(final IColor c) {
	super(c);
    }

    @Override
    public void applyColor() {
	System.out.print("Triangle filled with color ");
	color.applyColor();
    }

}