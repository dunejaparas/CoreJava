package com.pd.core.patterns.structural.facade.example.drawing;

public class FacadeShapeDemo {
    public static void main(final String[] args) {
	final ShapeMaker shapeMaker = new ShapeMaker();

	shapeMaker.drawCircle();
	shapeMaker.drawRectangle();
	shapeMaker.drawSquare();
    }
}