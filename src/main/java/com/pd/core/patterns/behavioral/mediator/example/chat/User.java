package com.pd.core.patterns.behavioral.mediator.example.chat;

/**
 *
 * Users can send and receive messages, so we can have User interface or
 * abstract class. I am creating User as abstract class like below.
 *
 */
public abstract class User {
    protected IChatMediator mediator;
    protected String name;

    public User(final IChatMediator med, final String name) {
	this.mediator = med;
	this.name = name;
    }

    public abstract void send(String msg);

    public abstract void receive(String msg);
}
/**
 * Notice that User has a reference to the mediator object, it’s required for
 * the communication between different users.
 * */
