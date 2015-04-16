package com.pd.core.patterns.behavioral.mediator.example.chat2;

public class MediatorPatternDemo {
    public static void main(final String[] args) {
	final User robert = new User("Robert");
	final User john = new User("John");

	robert.sendMessage("Hi! John!");
	john.sendMessage("Hello! Robert!");

    }

}