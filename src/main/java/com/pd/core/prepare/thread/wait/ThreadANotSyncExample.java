package com.pd.core.prepare.thread.wait;

public class ThreadANotSyncExample {
	public static void main(final String[] args) throws InterruptedException {
		final NotSyncThreadB b = new NotSyncThreadB();
		b.start();
		System.out.println("Total is: " + b.total);
		b.join();

		final NotSyncThreadB bb = new NotSyncThreadB();
		bb.start();
		bb.join();
		System.out.println("Total is: " + bb.total);

	}
}

class NotSyncThreadB extends Thread {
	int total;

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			total += i;
		}
	}
}