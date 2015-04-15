package com.pd.core.patterns.structural.decorator.example.shape;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(final IShape decoratedShape) {
	super(decoratedShape);
    }

    @Override
    public void draw() {
	decoratedShape.draw();
	setRedBorder(decoratedShape);
    }

    private void setRedBorder(final IShape decoratedShape) {
	System.out.println("Border Color: Green");
    }
}
