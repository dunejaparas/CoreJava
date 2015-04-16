package com.pd.core.patterns.behavioral.observer.example.binary;

public class HexadecimalObserver extends Observer {

    public HexadecimalObserver(final Subject subject) {
	this.subject = subject;
	this.subject.attach(this);
    }

    @Override
    public void update() {
	System.out.println("Hexadecimal String: " + Integer.toHexString(subject.getState()));
    }
}
