package com.pd.core.patterns.structural.facade.example.drawing;

/**
 *
 * Create a facade class.
 *
 *
 *
 */
public class ShapeMaker {
    private final IShape circle;
    private final IShape rectangle;
    private final IShape square;

    public ShapeMaker() {
	circle = new Circle();
	rectangle = new Rectangle();
	square = new Square();
    }

    public void drawCircle() {
	circle.draw();
    }

    public void drawRectangle() {
	rectangle.draw();
    }

    public void drawSquare() {
	square.draw();
    }
}