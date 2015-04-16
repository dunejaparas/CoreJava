package com.pd.core.patterns.behavioral.observer.example.subject;

/**
 *
 * Notice the implementation of update() method where it’s calling Subject
 * getUpdate() method to get the message to consume. We could have avoided this
 * call by passing message as argument to update() method.
 * 
 * Here is a simple test program to consume our topic implementation.
 *
 */
public class MyTopicSubscriber implements IObserver {

    private final String name;
    private ISubject topic;

    public MyTopicSubscriber(final String nm) {
	this.name = nm;
    }

    @Override
    public void update() {
	final String msg = (String) topic.getUpdate(this);
	if (msg == null) {
	    System.out.println(name + ":: No new message");
	} else {
	    System.out.println(name + ":: Consuming message::" + msg);
	}
    }

    @Override
    public void setSubject(final ISubject sub) {
	this.topic = sub;
    }

}