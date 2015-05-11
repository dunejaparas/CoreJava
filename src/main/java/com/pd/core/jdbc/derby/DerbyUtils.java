package com.pd.core.jdbc.derby;

import java.io.IOException;
import java.sql.*;

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

    public static void loadJdbcClientDriver() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	// LOAD Driver
	Class.forName(StringBundle.JDBC_CLIENT_DRIVER).newInstance();
    }

    public static Connection loadDbDriverAndCreateConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	loadJdbcClientDriver();
	return DriverManager.getConnection(StringBundle.DB_URL);
    }

    public static void closeConnection(final Connection connection) {
	try {
	    if (connection != null) {
		connection.close();
	    }
	} catch (final SQLException e) {
	    e.printStackTrace();
	}
    }

    public static PreparedStatement prepareStatement(final Connection connection, final String sqlForPreparedStatement) throws SQLException {
	return connection.prepareStatement(sqlForPreparedStatement);
    }

    public static PreparedStatement prepareStatement(final Connection connection, final String sqlPreparedStatementInsert, final int concurUpdatable) throws SQLException {
	return connection.prepareStatement(sqlPreparedStatementInsert, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    public static void executeDDL(final Connection connection, final String ddlString) {

	try {
	    final Statement stmt = connection.createStatement();
	    final boolean execute = stmt.execute(ddlString);
	    stmt.close();
	    System.out.println(String.format("********* Was execution of %s a SUCCESS %s", ddlString, execute));
	} catch (final SQLException ex) {
	    System.out.println("****************************************");
	    System.out.println("***		ERROR		********");
	    System.out.println("****************************************");
	    ex.printStackTrace();
	}
    }

    public static void getResultSetConcurrencyInfo(final ResultSet resultSet) throws SQLException {
	final int rsConcurrency = resultSet.getConcurrency();
	if (rsConcurrency == java.sql.ResultSet.CONCUR_READ_ONLY) {
	    System.out.println("java.sql.ResultSet.CONCUR_READ_ONLY");
	} else if (rsConcurrency == java.sql.ResultSet.CONCUR_UPDATABLE) {
	    System.out.println("java.sql.ResultSet.CONCUR_UPDATABLE");
	} else {
	    // it is an error
	    System.err.println("java.sql.ResultSet. XXXXX it is an error");
	}

    }
}