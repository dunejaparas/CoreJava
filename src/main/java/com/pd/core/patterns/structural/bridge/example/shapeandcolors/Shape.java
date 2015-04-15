package com.pd.core.patterns.structural.bridge.example.shapeandcolors;


public abstract class Shape {
    // Composition - implementor
    protected IColor color;

    // constructor with implementor as input argument
    public Shape(final IColor c) {
	this.color = c;
    }

    abstract public void applyColor();
}
