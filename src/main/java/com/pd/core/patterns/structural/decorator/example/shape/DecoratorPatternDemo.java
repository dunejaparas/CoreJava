package com.pd.core.patterns.structural.decorator.example.shape;

public class DecoratorPatternDemo {
    public static void main(final String[] args) {

	final IShape circle = new Circle();

	final IShape redCircle = new RedShapeDecorator(new Circle());

	final IShape redRectangle = new RedShapeDecorator(new Rectangle());
	System.out.println("Circle with normal border");
	circle.draw();

	System.out.println("\nCircle of red border");
	redCircle.draw();

	System.out.println("\nRectangle of red border");
	redRectangle.draw();
    }
}
