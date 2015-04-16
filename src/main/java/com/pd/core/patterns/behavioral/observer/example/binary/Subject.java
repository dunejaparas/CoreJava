package com.pd.core.patterns.behavioral.observer.example.binary;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Create Subject class.
 *
 */
public class Subject {

    private final List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
	return state;
    }

    public void setState(final int state) {
	this.state = state;
	notifyAllObservers();
    }

    public void attach(final Observer observer) {
	observers.add(observer);
    }

    public void notifyAllObservers() {
	for (final Observer observer : observers) {
	    observer.update();
	}
    }
}