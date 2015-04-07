package com.pd.core.patterns.creational.prototype.ex1;

public class Square extends Shape {

    public Square() {
	type = "Square";
    }

    @Override
    public void draw() {
	System.out.println("Inside Square::draw() method.");
    }
}