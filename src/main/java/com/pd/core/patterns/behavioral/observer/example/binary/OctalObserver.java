package com.pd.core.patterns.behavioral.observer.example.binary;

public class OctalObserver extends Observer {

    public OctalObserver(final Subject subject) {
	this.subject = subject;
	this.subject.attach(this);
    }

    @Override
    public void update() {
	System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
