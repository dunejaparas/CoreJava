package com.pd.core.prepare.thread;

public class ThreadTest extends Thread {
    @Override
    public void run() {
	System.out.println("In run");
	yield();
	System.out.println("Leaving run");
    }

    public static void main(final String[] argv) {
	(new ThreadTest()).start();
    }
}
