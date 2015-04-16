package com.pd.core.patterns.behavioral.mediator.example.chat2;

import java.util.Date;

public class ChatRoom {
    public static void showMessage(final User user, final String message) {
	System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}