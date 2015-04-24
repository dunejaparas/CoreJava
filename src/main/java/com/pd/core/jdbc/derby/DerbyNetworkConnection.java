package com.pd.core.jdbc.derby;

import java.io.IOException;
import java.sql.*;

public class DerbyNetworkConnection {

    private static final String CREATE_TABLE_SQL = "create table restaurants(id integer, name varchar(20), city varchar(50))";
    private static final String JDBC_EMBEDDED_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String SERVER_DERBY_START = "java -jar derbyrun.jar server start";
    private static final String SERVER_DERBY_SHUTDOWN = "java -jar derbyrun.jar server shutdown";
    private static final String DB_URL = "jdbc:derby://localhost:1527/derbyDB;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main(final String[] args) {
	new DerbyNetworkConnection().begin();
    }

    private void begin() {
	try {
	    executeCommand(SERVER_DERBY_START);
	    createConnection();
	    createTable();
	    insertIntoTable();
	    runSelectQuery();
	    shutdownConnection();
	    executeCommand(SERVER_DERBY_SHUTDOWN);

	} catch (final IOException | InterruptedException | InstantiationException | IllegalAccessException
		| ClassNotFoundException | SQLException e) {
	    e.printStackTrace();
	} finally {

	}

    }

    private void insertIntoTable() throws SQLException {
	// stmt.execute("insert into restaurants values (1, 'Irifunes', 'San Mateo')");
	//
	// stmt.execute("insert into restaurants values (2, 'Estradas', 'Daly City')");
	//
	// stmt.execute("insert into restaurants values (3, 'Prime Rib House', 'San Francisco')");

	stmt.execute("select * from restaurants");
    }

    private static void runSelectQuery() {
	try {
	    stmt = conn.createStatement();
	    final ResultSet results = stmt.executeQuery("select * from restaurants");
	    final ResultSetMetaData rsmd = results.getMetaData();
	    final int numberCols = rsmd.getColumnCount();
	    for (int i = 1; i <= numberCols; i++) {
		// print Column Names
		System.out.print(rsmd.getColumnLabel(i) + "\t\t");
	    }

	    System.out.println("\n-------------------------------------------------");

	    while (results.next()) {
		final int id = results.getInt(1);
		final String restName = results.getString(2);
		final String cityName = results.getString(3);
		System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
	    }
	    results.close();
	    stmt.close();
	} catch (final SQLException sqlExcept) {
	    sqlExcept.printStackTrace();
	}
    }

    private void createTable() throws SQLException {
	try {
	    if (stmt == null) {
		stmt = conn.createStatement();
	    }
	    stmt.execute(CREATE_TABLE_SQL);
	    System.out.println("Created table 'restaurants'");
	} catch (final SQLException e) {
	    if (DerbyUtils.tableAlreadyExists(e)) {
		return;
	    }
	    e.printStackTrace();
	}

    }

    private void executeCommand(final String command) throws IOException, InterruptedException {
	Runtime.getRuntime().exec(command);
	System.out.println("Executed command #" + command);
	Thread.sleep(2000);
    }

    private void createConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException,
	    SQLException {
	Class.forName(JDBC_EMBEDDED_DRIVER).newInstance();
	// Get a connection
	conn = DriverManager.getConnection(DB_URL);
	if (conn != null) {
	    System.out.println("Connected to persistence database, not in memory");
	}
    }

    private void shutdownConnection() throws SQLException {
	if (stmt != null) {
	    stmt.close();
	    System.out.println("Closed open statement");
	}

    }
}
