package com.pd.core.patterns.structural.flyweight.example.drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Line implements Shape {

    public Line() {
	System.out.println("Creating Line object");
	// adding time delay
	try {
	    /**
	     * Notice the delay in creating the Object of concrete classes to
	     * make the point that flyweight pattern can be used for Objects
	     * that takes a lot of time while instantiated.
	     */
	    Thread.sleep(2000);
	} catch (final InterruptedException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void draw(final Graphics line, final int x1, final int y1, final int x2, final int y2, final Color color) {
	line.setColor(color);
	line.drawLine(x1, y1, x2, y2);
    }

}