package com.pd.core.patterns.behavioral.strategy.example.behaviour;

public class Robot {
    IBehaviour behaviour;
    String name;

    public Robot(final String name) {
	this.name = name;
    }

    public void setBehaviour(final IBehaviour behaviour) {
	this.behaviour = behaviour;
    }

    public IBehaviour getBehaviour() {
	return behaviour;
    }

    public void move() {
	System.out.println(this.name + ": Based on current position" + "the behaviour object decide the next move:");
	final int command = behaviour.moveCommand();
	// ... send the command to mechanisms
	System.out.println("\tThe result returned by behaviour object " + "is sent to the movement mechanisms "
		+ " for the robot '" + this.name + "'");
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }
}
