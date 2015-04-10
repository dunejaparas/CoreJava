package com.pd.core.patterns.structural.composite.example.draw;

/**
 *
 * Leaf Objects
 * 
 * Leaf implements base component and these are the building block for the
 * composite. We can create multiple leaf objects such as Triangle, Circle etc.
 *
 */
public class Circle implements Shape {

    @Override
    public void draw(final String fillColor) {
	System.out.println("Drawing Circle with color " + fillColor);
    }

}
