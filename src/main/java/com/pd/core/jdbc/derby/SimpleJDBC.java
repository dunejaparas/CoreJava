package com.pd.core.jdbc.derby;

/*
 * Loading the JDBC Driver

 The first thing you need to do before you can open a database connection is to load the JDBC driver for the database.
 Actually, from Java 6 this is no longer necessary, but doing so will not fail. You load the JDBC driver like this:

 Class.forName("driverClassName");
 Each JDBC driver has a primary driver class that initializes the driver when it is loaded. For instance, to load
 the H2Database driver, you write this:

 Class.forName("org.h2.Driver");
 You only have to load the driver once. You do not need to load it before every connection opened. Only before the
 first connection opened.

 Opening the Connection

 To open a database connection you use the java.sql.DriverManager class. You call its getConnection() method, like this:

 String url      = "jdbc:h2:~/test";   //database specific url.
 String user     = "sa";
 String password = "";

 Connection connection =
 DriverManager.getConnection(url, user, password);
 The url is the url to your database. You should check the documentation for your database and JDBC driver to see what the
 format is for your specific database. The url shown above is for a H2Database.

 The user and password parameters are the user name and password for your database.

 Closing the Connection
 Once you are done using the database connection you should close it. This is done by calling the Connection.close() method,
 like this:

 connection.close();
 */

public class SimpleJDBC {
    public static void main(final String args[]) {
	try {

	    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	    System.out.println("yippie!");
	} catch (final ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }
}
