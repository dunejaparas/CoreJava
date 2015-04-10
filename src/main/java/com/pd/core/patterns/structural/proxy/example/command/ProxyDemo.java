package com.pd.core.patterns.structural.proxy.example.command;

/**
 *
 *
 * 
 *
 * Proxy pattern common uses are to control access or to provide a wrapper
 * implementation for better performance.
 *
 */
public class ProxyDemo {
    public static void main(final String[] args) {
	final CommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
	try {
	    executor.runCommand("ls -ltr");
	    executor.runCommand(" rm -rf abc.pdf");
	} catch (final Exception e) {
	    System.out.println("Exception Message::" + e.getMessage());
	}

    }
}
