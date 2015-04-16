package com.pd.core.patterns.behavioral.observer.example.binary;

public class ObserverPatternDemo {
    public static void main(final String[] args) {
	final Subject subject = new Subject();

	new HexadecimalObserver(subject);
	new OctalObserver(subject);
	new BinaryObserver(subject);

	// Each Binary Octal Hexadecimal Observer is observing state and prints
	// equivalent value
	System.out.println("First state change: 15");
	subject.setState(15);
	System.out.println("Second state change: 10");
	subject.setState(10);
    }
}