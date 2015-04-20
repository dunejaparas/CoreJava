package com.pd.core.patterns.behavioral.command.example.filesystem;

/**
 *
 * FileSystemReceiver interface defines the contract for the implementation
 * classes.
 *
 * For simplicity, creating two flavors of receiver classes to work with Unix
 * and Windows systems.
 *
 */
public class WindowsFileSystemReceiver implements IFileSystemReceiver {

    @Override
    public void openFile() {
	System.out.println("Opening file in windows OS");
    }

    @Override
    public void writeFile() {
	System.out.println("Writing file in windows OS");
    }

    @Override
    public void closeFile() {
	System.out.println("Closing file in windows OS");
    }

}