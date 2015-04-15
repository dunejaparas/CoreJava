package com.pd.core.patterns.structural.decorator.example.car;

public class DecoratorPatternDemo {
    public static void main(final String[] args) {
	final ICar sportsCar = new SportsCar(new BasicCar());
	sportsCar.assemble();
	System.out.println("\n*****");

	final ICar sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
	sportsLuxuryCar.assemble();

	System.out.println("\n*****");
	final ICar luxuryCar = new LuxuryCar(new BasicCar());
	luxuryCar.assemble();
    }
}
