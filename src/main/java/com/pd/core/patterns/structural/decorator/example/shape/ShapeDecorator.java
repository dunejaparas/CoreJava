package com.pd.core.patterns.structural.decorator.example.shape;

public class ShapeDecorator implements IShape {

    protected IShape decoratedShape;

    public ShapeDecorator(final IShape decoratedShape) {
	this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
	decoratedShape.draw();
    }
}
