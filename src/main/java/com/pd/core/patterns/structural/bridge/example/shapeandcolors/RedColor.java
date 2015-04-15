package com.pd.core.patterns.structural.bridge.example.shapeandcolors;

public class RedColor implements IColor {

    @Override
    public void applyColor() {
	System.out.println("red.");
    }
}