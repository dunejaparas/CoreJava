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
public interface IFileSystemReceiver {

    void openFile();

    void writeFile();

    void closeFile();
}
