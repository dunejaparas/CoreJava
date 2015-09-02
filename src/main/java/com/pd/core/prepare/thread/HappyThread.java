package com.pd.core.prepare.thread;

public class HappyThread extends Thread {
	final StringBuffer sb1 = new StringBuffer();
	final StringBuffer sb2 = new StringBuffer();

	public static void main(final String args[]) {
		final HappyThread h = new HappyThread();

		new Thread() {
			@Override
			public void run() {
				synchronized (this) {
					System.out.println("first");
					h.sb1.append("A");
					h.sb2.append("B");
					System.out.println(h.sb1);
					System.out.println(h.sb2);
				}
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				synchronized (this) {
					System.out.println("second");
					h.sb1.append("D");
					h.sb2.append("C");
					System.out.println(h.sb2);
					System.out.println(h.sb1);
				}
			}
		}.start();

		System.out.println("Main ends");
	}
}
