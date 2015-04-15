package com.pd.core.patterns.structural.decorator.example.shape;

public class GreenShapeDecorator extends ShapeDecorator {

    public GreenShapeDecorator(final IShape decoratedShape) {
	super(decoratedShape);
    }

    @Override
    public void draw() {
	decoratedShape.draw();
	setRedBorder(decoratedShape);
    }

    private void setRedBorder(final IShape decoratedShape) {
	System.out.println("Border Color: Red");
    }
}
