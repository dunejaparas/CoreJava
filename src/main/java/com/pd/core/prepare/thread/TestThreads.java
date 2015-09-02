package com.pd.core.prepare.thread;

public class TestThreads {

	public static void main(final String[] args) {
		new MyThreadExtends().start();
		new MyThreadExtends(new MyRunnable()).start();
	}

}

class MyThreadExtends extends Thread {
	MyThreadExtends() {
	}

	MyThreadExtends(final Runnable r) {
		super(r);
	}

	@Override
	public void run() {
		System.out.print("Inside Thread ");
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.print(" Inside Runnable");
	}
}
