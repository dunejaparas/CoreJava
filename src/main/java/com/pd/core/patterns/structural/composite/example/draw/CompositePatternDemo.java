package com.pd.core.patterns.structural.composite.example.draw;

/**
 *
 * Important Points about Composite Pattern
 * 
 * Composite pattern should be applied only when the group of objects should
 * behave as the single object. Composite pattern can be used to create a tree
 * like structure.
 *
 */
public class CompositePatternDemo {

    public static void main(final String[] args) {
	final Shape tri = new Triangle();
	final Shape tri1 = new Triangle();
	final Shape cir = new Circle();

	final Drawing drawing = new Drawing();
	drawing.add(tri1);
	drawing.add(tri1);
	drawing.add(cir);

	drawing.draw("Red");

	drawing.clear();

	drawing.add(tri);
	drawing.add(cir);
	drawing.draw("Green");
    }

}
