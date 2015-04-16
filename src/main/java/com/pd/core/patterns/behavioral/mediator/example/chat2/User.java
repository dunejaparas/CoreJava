package com.pd.core.patterns.behavioral.mediator.example.chat2;

public class User {
    private String name;

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public User(final String name) {
	this.name = name;
    }

    public void sendMessage(final String message) {
	ChatRoom.showMessage(this, message);
    }
}