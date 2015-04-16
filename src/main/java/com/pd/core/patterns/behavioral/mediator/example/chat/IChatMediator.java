package com.pd.core.patterns.behavioral.mediator.example.chat;

/**
 *
 * First of all we will create Mediator interface that will define the contract
 * for concrete mediators.
 * 
 * 
 *
 */
public interface IChatMediator {

    public void sendMessage(String msg, User user);

    void addUser(User user);
}