package com.pd.core.prepare.thread.wait;

public class ThreadASyncExample {
	public static void main(final String[] args) {
		final SyncThreadB b = new SyncThreadB();
		b.start();

		synchronized (b) {
			try {
				System.out.println("Waiting for b to complete...");
				b.wait();
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Total is: " + b.total);
		}
	}
}

class SyncThreadB extends Thread {
	int total;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				total += i;
			}
			notify();
		}
	}
}