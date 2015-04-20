package com.pd.core.patterns.behavioral.command.example.filesystem;

/**
 * We can use interface or abstract class to create our base Command, it’s a
 * design decision and depends on your requirement. We are going with interface
 * because we don’t have any default implementations.
 *
 */
public interface ICommand {

    void execute();

}
