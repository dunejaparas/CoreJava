package com.pd.core.patterns.structural.flyweight.example.drawing;

import java.util.HashMap;

/**
 *
 * Flyweight Factory
 *
 * The flyweight factory will be used by client programs to instantiate the
 * Object, so we need to keep a map of Objects in the factory that should not be
 * accessible by client application. Whenever client program makes a call to get
 * an instance of Object, it should be returned from the HashMap, if not found
 * then create a new Object and put in the Map and then return it. We need to
 * make sure that all the intrinsic properties are considered while creating the
 * Object.
 *
 * Our flyweight factory class looks like below code.
 *
 */

public class ShapeFactory {
    /**
     * Notice the use of Java Enum for type safety, Java Composition (shapes
     * map) and Factory pattern in getShape method.
     */
    private static final HashMap<ShapeType, Shape> shapes = new HashMap<ShapeType, Shape>();

    public static Shape getShape(final ShapeType type) {
	Shape shapeImpl = shapes.get(type);

	if (shapeImpl == null) {
	    if (ShapeType.OVAL_FILL.equals(type)) {
		shapeImpl = new Oval(true);
	    } else if (ShapeType.OVAL_NOFILL.equals(type)) {
		shapeImpl = new Oval(false);
	    } else if (ShapeType.LINE.equals(type)) {
		shapeImpl = new Line();
	    }
	    shapes.put(type, shapeImpl);
	}
	return shapeImpl;
    }

    public static enum ShapeType {
	OVAL_FILL, OVAL_NOFILL, LINE;
    }
}