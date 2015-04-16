package com.pd.core.patterns.behavioral.mediator.example.chat;

public class MediatorChatDemo {
    public static void main(final String[] args) {
	final IChatMediator mediator = new ChatMediatorImpl();
	final User user1 = new UserImpl(mediator, "Pankaj");
	final User user2 = new UserImpl(mediator, "Lisa");
	final User user3 = new UserImpl(mediator, "Saurabh");
	final User user4 = new UserImpl(mediator, "David");
	mediator.addUser(user1);
	mediator.addUser(user2);
	mediator.addUser(user3);
	mediator.addUser(user4);

	user1.send("Hi All");

    }
}
