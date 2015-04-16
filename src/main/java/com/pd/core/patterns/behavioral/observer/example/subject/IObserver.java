package com.pd.core.patterns.behavioral.observer.example.subject;

/**
 * Next we will create contract for Observer, there will be a method to attach
 * the Subject to the observer and another method to be used by Subject to
 * notify of any change.
 */

public interface IObserver {

    // method to update the observer, used by subject
    public void update();

    // attach with subject to observe
    public void setSubject(ISubject sub);
}