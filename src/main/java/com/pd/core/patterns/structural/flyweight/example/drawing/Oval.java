package com.pd.core.patterns.structural.flyweight.example.drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Oval implements Shape {

    // intrinsic property
    private final boolean fill;

    public Oval(final boolean f) {
	this.fill = f;
	System.out.println("Creating Oval object with fill=" + f);
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
    public void draw(final Graphics circle, final int x, final int y, final int width, final int height,
	    final Color color) {
	circle.setColor(color);
	circle.drawOval(x, y, width, height);
	if (fill) {
	    circle.fillOval(x, y, width, height);
	}
    }

}