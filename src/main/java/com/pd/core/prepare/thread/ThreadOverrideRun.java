package com.pd.core.prepare.thread;

public class ThreadOverrideRun extends Thread {

	public ThreadOverrideRun() {
		System.out.print("Sample ");
	}

	@Override
	public void run() {
		System.out.println("In instance run");
	}

	public static void main(final String[] argv) {
		final ThreadOverrideRun t = new ThreadOverrideRun() {
			@Override
			public void run() {
				System.out.println(" case");
			}
		};

		t.start();
	}
}
