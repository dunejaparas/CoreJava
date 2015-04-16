package com.pd.core.patterns.behavioral.observer.example.subject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * The method implementation to register and unregister an observer is very
 * simple, the extra method is postMessage() that will be used by client
 * application to post String message to the topic. Notice the boolean variable
 * to keep track of the change in the state of topic and used in notifying
 * observers. This variable is required so that if there is no update and
 * somebody calls notifyObservers() method, it doesn’t send false notifications
 * to the observers.
 *
 * Also notice the use of synchronization in notifyObservers() method to make
 * sure the notification is sent only to the observers registered before the
 * message is published to the topic.
 *
 * Here is the implementation of Observers that will watch over the subject.
 *
 */
public class MyTopic implements ISubject {

    private final List<IObserver> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyTopic() {
	this.observers = new ArrayList<>();
    }

    @Override
    public void register(final IObserver obj) {
	if (obj == null) {
	    throw new NullPointerException("Null Observer");
	}
	synchronized (MUTEX) {
	    if (!observers.contains(obj)) {
		observers.add(obj);
	    }
	}
    }

    @Override
    public void unregister(final IObserver obj) {
	synchronized (MUTEX) {
	    observers.remove(obj);
	}
    }

    @Override
    public void notifyObservers() {
	List<IObserver> observersLocal = null;
	// synchronization is used to make sure any observer registered after
	// message is received is not notified
	synchronized (MUTEX) {
	    if (!changed) {
		return;
	    }
	    observersLocal = new ArrayList<>(this.observers);
	    this.changed = false;
	}
	for (final IObserver obj : observersLocal) {
	    obj.update();
	}

    }

    @Override
    public Object getUpdate(final IObserver obj) {
	return this.message;
    }

    // method to post message to the topic
    public void postMessage(final String msg) {
	System.out.println("Message Posted to Topic:" + msg);
	this.message = msg;
	this.changed = true;
	notifyObservers();
    }

}