package com.pd.core.patterns.behavioral.mediator.example.chat;

/**
 * Now we can create concrete User classes to be used by client system.
 *
 *
 * Notice that send() method is using mediator to send the message to the users
 * and it has no idea how it will be handled by the mediator
 */
public class UserImpl extends User {

    public UserImpl(final IChatMediator med, final String name) {
	super(med, name);
    }

    @Override
    public void send(final String msg) {
	System.out.println(this.name + ": Sending Message=" + msg);
	mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(final String msg) {
	System.out.println(this.name + ": Received Message:" + msg);
    }

}