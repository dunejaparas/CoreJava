package com.pd.core.prepare.thread;

public class Test107 implements Runnable {
	private int x;
	private int y;

	public static void main(final String args[]) {
		final Test107 that = new Test107();
		(new Thread(that)).start();
		(new Thread(that)).start();
	}

	@Override
	public synchronized void run() {
		System.out.println("Thread name" + Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			x++;
			y++;
			System.out.println("x = " + x + ", y = " + y); /* Line 17 */
		}
	}
}