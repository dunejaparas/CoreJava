package com.pd.core.patterns.behavioral.command.example.filesystem;

/**
 * Now we need to create implementations for all the different types of action
 * performed by the receiver, since we have three actions we will create three
 * Command implementations and each Command implementation will forward the
 * request to the appropriate method of receiver.
 */
public class CloseFileCommand implements ICommand {

    private final IFileSystemReceiver fileSystem;

    public CloseFileCommand(final IFileSystemReceiver fs) {
	this.fileSystem = fs;
    }

    @Override
    public void execute() {
	// open command is forwarding request to closeFile method
	this.fileSystem.closeFile();
    }

}