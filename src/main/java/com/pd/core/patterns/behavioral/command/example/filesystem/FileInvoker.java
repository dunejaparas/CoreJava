package com.pd.core.patterns.behavioral.command.example.filesystem;

/**
 *
 * Invoker is a simple class that encapsulates the Command and passes the
 * request to the command object to process it.
 *
 */
public class FileInvoker {

    public ICommand command;

    public FileInvoker(final ICommand c) {
	this.command = c;
    }

    public void execute() {
	this.command.execute();
    }
}