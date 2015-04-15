package com.pd.core.patterns.behavioral.template.example.house;

/**
 *
 * We can have different type of houses, such as Wooden House and Glass House.
 *
 *
 *
 */
public class WoodenHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
	System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
	System.out.println("Building Pillars with Wood coating");
    }

}
