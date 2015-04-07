package com.pd.core.patterns.creational.prototype.ex1;

public class PrototypePatternDemo {
    public static void main(final String[] args) {
	ShapeCache.loadCache();

	final Shape clonedShape = ShapeCache.getShape("1");
	System.out.println("Shape : " + clonedShape.getType());

	final Shape clonedShape2 = ShapeCache.getShape("2");
	System.out.println("Shape : " + clonedShape2.getType());

	final Shape clonedShape3 = ShapeCache.getShape("3");
	System.out.println("Shape : " + clonedShape3.getType());
    }
}