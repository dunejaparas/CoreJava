package com.pd.core.patterns.structural.bridge.example.shapeandcolors;

public class Pentagon extends Shape {

    public Pentagon(final IColor c) {
	super(c);
    }

    @Override
    public void applyColor() {
	System.out.print("Pentagon filled with color ");
	color.applyColor();
    }

}