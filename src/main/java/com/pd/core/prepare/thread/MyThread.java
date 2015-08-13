package com.pd.core.prepare.thread;

class MyThread extends Thread {
    public static void main(final String[] args) {
	final MyThread t = new MyThread();
	t.start();
	System.out.print("one. ");
	t.start();
	System.out.print("two. ");
    }

    @Override
    public void run() {
	System.out.print("Thread ");
    }
}