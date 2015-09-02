package com.pd.core.prepare.thread;

class s implements Runnable {
	int x, y;

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			synchronized (this) {
				x = 12;
				y = 12;
			}
		}
		System.out.print(x + " " + y + " ");
	}

	public static void main(final String args[]) {
		final s run = new s();
		final Thread t1 = new Thread(run);
		final Thread t2 = new Thread(run);
		t1.start();
		t2.start();
	}
}
