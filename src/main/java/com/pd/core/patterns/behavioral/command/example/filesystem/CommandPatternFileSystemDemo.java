package com.pd.core.patterns.behavioral.command.example.filesystem;

public class CommandPatternFileSystemDemo {
    public static void main(final String[] args) {
	// Creating the receiver object
	final IFileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

	// creating command and associating with receiver
	final OpenFileCommand openFileCommand = new OpenFileCommand(fs);

	// Creating invoker and associating with Command
	FileInvoker file = new FileInvoker(openFileCommand);

	// perform action on invoker object
	file.execute();

	final WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
	file = new FileInvoker(writeFileCommand);
	file.execute();

	final CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
	file = new FileInvoker(closeFileCommand);
	file.execute();
    }
}
/**
 * Notice that client is responsible to create the appropriate type of command
 * object, for example if you want to write a file you are not supposed to
 * create CloseFileCommand object. Client program is also responsible to attach
 * receiver to the command and then command to the invoker class.
 */
