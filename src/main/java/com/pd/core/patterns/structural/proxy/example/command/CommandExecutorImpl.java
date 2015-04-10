package com.pd.core.patterns.structural.proxy.example.command;

import java.io.IOException;

public class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void runCommand(final String cmd) throws IOException {
	// some heavy implementation
	Runtime.getRuntime().exec(cmd);
	System.out.println("'" + cmd + "' command executed.");
    }

}