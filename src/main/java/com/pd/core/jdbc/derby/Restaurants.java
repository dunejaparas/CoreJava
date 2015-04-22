package com.pd.core.jdbc.derby;

import java.sql.*;

public class Restaurants {
    /**
     * Example connection URLs: Connect and create a database called webdb under
     * the directory codejava. The database path is relative to the system
     * directory. jdbc:derby:codejava/webdb;create=true
     *
     * Connect to a database in the file system using absolute path:
     * jdbc:derby:E:/projects/codejava/webdb;create=true
     *
     * Connect and create a database if not exist in the memory:
     * jdbc:derby:memory:codejava/webdb;create=true
     *
     * Connect to a database presents in the classpath:
     * jdbc:derby:classpath:webdb
     *
     * Where the absolute directory E:/projects/codejava is added to the
     * classpath.
     *
     * Connect to a database called webdb inside a jar file which is on the
     * classpath: jdbc:derby:jar:webdb
     *
     * Connect to a database called webdb inside a jar file db.jar which is not
     * on the classpath: jdbc:derby:jar:(E:/projects/db.jar)webdb
     *
     * Shutdown the current database: jdbc:derby:;shutdown=true
     */
    private static String dbURL = "jdbc:derby:memory:codejava/webdb;create=true";
    private static String tableName = "restaurants";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main(final String[] args) {
	createConnection();
	createTable();
	insertRestaurants(5, "LaVals", "Berkeley");
	selectRestaurants();
	shutdown();
    }

    private static void createTable() {
	/*
	 * create table restaurants(id integer, name varchar(20), city
	 * varchar(50));
	 * 
	 * insert into restaurants values (1, 'Irifunes', 'San Mateo');
	 * 
	 * insert into restaurants values (2, 'Estradas', 'Daly City');
	 * 
	 * insert into restaurants values (3, 'Prime Rib House', 'San
	 * Francisco');
	 * 
	 * select * from restaurants;
	 */
	try {
	    stmt = conn.createStatement();
	    stmt.execute("create table restaurants(id integer, name varchar(20), city varchar(50))");
	    stmt.close();
	} catch (final SQLException sqlExcept) {
	    sqlExcept.printStackTrace();
	}

    }

    private static void insertRestaurants(final int id, final String restName, final String cityName) {
	try {
	    stmt = conn.createStatement();
	    stmt.execute("insert into " + tableName + " values (" + id + ",'" + restName + "','" + cityName + "')");
	    stmt.close();
	} catch (final SQLException sqlExcept) {
	    sqlExcept.printStackTrace();
	}
    }

    private static void selectRestaurants() {
	try {
	    stmt = conn.createStatement();
	    final ResultSet results = stmt.executeQuery("select * from " + tableName);
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

    /**
     * Example connection URLs: Connect and create a database called webdb under
     * the directory codejava. The database path is relative to the system
     * directory. jdbc:derby:codejava/webdb;create=true
     *
     * Connect to a database in the file system using absolute path:
     * jdbc:derby:E:/projects/codejava/webdb;create=true
     *
     * Connect and create a database if not exist in the memory:
     * jdbc:derby:memory:codejava/webdb;create=true
     *
     * Connect to a database presents in the classpath:
     * jdbc:derby:classpath:webdb
     *
     * Where the absolute directory E:/projects/codejava is added to the
     * classpath.
     *
     * Connect to a database called webdb inside a jar file which is on the
     * classpath: jdbc:derby:jar:webdb
     *
     * Connect to a database called webdb inside a jar file db.jar which is not
     * on the classpath: jdbc:derby:jar:(E:/projects/db.jar)webdb
     *
     * Shutdown the current database: jdbc:derby:;shutdown=true
     */
    private static void createConnection() {
	try {
	    Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
	    // Get a connection
	    conn = DriverManager.getConnection(dbURL);
	} catch (final Exception except) {
	    except.printStackTrace();
	}
    }

    private static void shutdown() {
	try {
	    if (stmt != null) {
		stmt.close();
	    }
	    if (conn != null) {
		DriverManager.getConnection("jdbc:derby:;shutdown=true");
		conn.close();
	    }
	} catch (final SQLException sqlExcept) {

	}

    }

}
