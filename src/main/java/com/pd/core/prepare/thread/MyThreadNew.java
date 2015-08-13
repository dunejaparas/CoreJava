package com.pd.core.prepare.thread;

public class MyThreadNew extends Thread {
    public static void main(final String[] args) {
	final MyThreadNew t = new MyThreadNew();
	final Thread x = new Thread(t);
	x.start(); /* Line 7 */
    }

    @Override
    public void run() {
	for (int i = 0; i < 3; ++i) {
	    System.out.print(i + "..");
	}
    }
}