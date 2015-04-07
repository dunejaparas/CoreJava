package com.pd.core.patterns.creational.prototype.ex1;

public class Rectangle extends Shape {

    public Rectangle() {
	type = "Rectangle";
    }

    @Override
    public void draw() {
	System.out.println("Inside Rectangle::draw() method.");
    }
}