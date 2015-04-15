package com.pd.core.patterns.structural.bridge.example.shapeandcolors;

public class GreenColor implements IColor {

    @Override
    public void applyColor() {
	System.out.println("green.");
    }
}