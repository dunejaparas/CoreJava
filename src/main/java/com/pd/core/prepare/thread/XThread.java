package com.pd.core.prepare.thread;

public class XThread implements Runnable {
    public static void main(final String args[]) {
	final XThread run = new XThread();
	final Thread t = new Thread(run);
	t.start();
    }

    @Override
    public void run() {
	System.out.println("yeay");
    }

}
