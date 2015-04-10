package com.pd.core.patterns.structural.composite.example.draw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Composite
 *
 * A composite object contains group of leaf objects and we should provide some
 * helper methods to add or delete leafs from the group. We can also provide a
 * method to remove all the elements from the group.
 *
 */
public class Drawing implements Shape {

    // collection of Shapes
    private final List<Shape> shapes = new ArrayList<Shape>();

    @Override
    public void draw(final String fillColor) {
	for (final Shape sh : shapes) {
	    sh.draw(fillColor);
	}
    }

    // adding shape to drawing
    public void add(final Shape s) {
	this.shapes.add(s);
    }

    // removing shape from drawing
    public void remove(final Shape s) {
	shapes.remove(s);
    }

    // removing all the shapes
    public void clear() {
	System.out.println("Clearing all the shapes from drawing");
	this.shapes.clear();
    }
}
