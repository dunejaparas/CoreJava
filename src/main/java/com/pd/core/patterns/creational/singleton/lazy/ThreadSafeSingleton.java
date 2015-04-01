package com.pd.core.patterns.creational.singleton.lazy;

/**
 *
 * The easier way to create a thread-safe singleton class is to make the global
 * access method synchronized, so that only one thread can execute this method
 * at a time. General implementation of this approach is like the below class.
 *
 *
 * The volatile keyword helps as concurrency control tool in a multithreaded
 * environment and provides the latest update in a most accurate manner.However
 * please note that double check locking might not work before Java 5. In such
 * situation we can use early loading mechanism. If we remember about the
 * original sample code we had used lazy loading. In case of early loading we
 * will instantiate the SingletonExample class at the start and this will be
 * referred to the private static instance field.
 */

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    /**
     *
     * the implementation below works fine and provides thread-safety but it
     * reduces the performance because of cost associated with the synchronized
     * method, although we need it only for the first few threads who might
     * create the separate instances (Read: Java Synchronization).
     * http://www.journaldev
     * .com/1061/java-synchronization-and-thread-safety-tutorial-with-examples
     *
     */
    public static synchronized ThreadSafeSingleton getInstance() {
	if (instance == null) {
	    instance = new ThreadSafeSingleton();
	}
	return instance;
    }

    /**
     *
     * To avoid the above mentioned extra overhead every time, double checked
     * locking principle is used. In this approach, the synchronized block is
     * used inside the if condition with an additional check to ensure that only
     * one instance of singleton class is created.
     *
     * Also note that instance variable should be declared as volatile
     *
     */
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
	if (instance == null) {
	    synchronized (ThreadSafeSingleton.class) {
		if (instance == null) {
		    instance = new ThreadSafeSingleton();
		}
	    }
	}
	return instance;
    }

}