package com.pd.core.patterns.behavioral.mediator.example.chat;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Now we will create concrete mediator class, it will have a list of users in
 * the group and provide logic for the communication between the users.
 */
public class ChatMediatorImpl implements IChatMediator {

    private final List<User> users;

    public ChatMediatorImpl() {
	this.users = new ArrayList<>();
    }

    @Override
    public void addUser(final User user) {
	this.users.add(user);
    }

    @Override
    public void sendMessage(final String msg, final User user) {
	for (final User u : this.users) {
	    // message should not be received by the user sending it
	    if (u != user) {
		u.receive(msg);
	    }
	}
    }

}