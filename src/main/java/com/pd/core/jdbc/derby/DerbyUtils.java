package com.pd.core.jdbc.derby;

import java.io.IOException;
import java.sql.SQLException;

public class DerbyUtils {

    private static final String SERVER_DERBY_START = "java -jar derbyrun.jar server start";
    private static final String SERVER_DERBY_SHUTDOWN = "java -jar derbyrun.jar server shutdown";

    public DerbyUtils() {
	// empty constructor -- helper class
    }

    public static boolean tableAlreadyExists(final SQLException e) {
	if (e.getSQLState().equals("X0Y32")) {
	    System.out.println("***		" + e.getMessage());
	    return true;
	}
	return false;
    }

    private static void executeCommand(final String command) throws IOException, InterruptedException {
	Runtime.getRuntime().exec(command);
	System.out.println("Executed command #" + command);
	Thread.sleep(2000);
    }

    public static void startDB() throws IOException, InterruptedException {
	executeCommand(SERVER_DERBY_START);
    }

    public static void shutdownDB() throws IOException, InterruptedException {
	executeCommand(SERVER_DERBY_SHUTDOWN);

    }
}