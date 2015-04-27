package com.pd.core.jdbc.derby;

import java.io.IOException;
import java.sql.SQLException;

// import org.apache.derby.drda.NetworkServerControl;

public class DerbyUtils {

    private static final String SERVER_DERBY_START = "java -jar derbyrun.jar server start";
    private static final String SERVER_DERBY_SHUTDOWN = "java -jar derbyrun.jar server shutdown";

    // private static NetworkServerControl serverControl;

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

	final Process exec = Runtime.getRuntime().exec(command);
	System.out.println("Executed command #" + command);
	final int waitFor = exec.waitFor();
	/*
	 * The exit value of the subprocess represented by this Process object.
	 * By convention, the value 0 indicates normal termination.
	 */
	System.out.println("The command executed with value:" + waitFor);
	Thread.sleep(2000);
    }

    // public static void startDBProgramatically() throws Exception {
    // startDBProgramatically(1527);
    // }
    //
    // public static void startDBProgramatically(final int port) throws
    // Exception {
    // serverControl = new NetworkServerControl();
    // serverControl.start(null);
    // }
    //
    // public static void shutdownDBProgramatically() throws Exception {
    // serverControl.shutdown();
    // }

    public static void startDB() throws IOException, InterruptedException {
	executeCommand(SERVER_DERBY_START);
    }

    public static void shutdownDB() throws IOException, InterruptedException {
	executeCommand(SERVER_DERBY_SHUTDOWN);

    }
}