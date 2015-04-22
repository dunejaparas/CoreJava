package com.pd.core.jdbc.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *
 *

 Making Derby JDBC connection examples

 With JDBC, there are three different ways to establishing a connection to the database, corresponding to three version of the method getConnection() of the DriverManager class:


 Using only a database URL:

 String dbURL = "jdbc:derby:codejava/webdb;create=true";
 Connection conn = DriverManager.getConnection(dbURL);

 Using a database URL with user and password:

 String dbURL = "jdbc:derby://localhost/webdb;create=true";
 String user = "tom";
 String password = "secret";
 Connection conn = DriverManager.getConnection(dbURL, user, password);


 Using a database URL with a Properties object:
 String dbURL = "jdbc:derby://localhost/webdb";
 Properties properties = new Properties();
 properties.put("create", "true");
 properties.put("user", "tom");
 properties.put("password", "secret");

 Connection conn = DriverManager.getConnection(dbURL, properties);

 *
 */
public class JdbcDerbyConnection {

    public static void main(final String[] args) {

	Connection conn = null;
	try {
	    // connect method #1 - embedded driver
	    final String dbURL1 = "jdbc:derby:codejava/webdb1;create=true";
	    conn = DriverManager.getConnection(dbURL1);
	    if (conn != null) {
		System.out.println("Connected to database #1");
	    }

	    // The following two will not work without running the DB from
	    // commandline
	    // // connect method #2 - network client driver
	    // final String dbURL2 =
	    // "jdbc:derby://localhost/webdb2;create=true";
	    // final String user = "tom";
	    // final String password = "secret";
	    // final Connection conn2 = DriverManager.getConnection(dbURL2,
	    // user, password);
	    // if (conn2 != null) {
	    // System.out.println("Connected to database #2");
	    // }
	    //
	    // // connect method #3 - network client driver
	    // final String dbURL3 = "jdbc:derby://localhost/webdb3";
	    // final Properties properties = new Properties();
	    // properties.put("create", "true");
	    // properties.put("user", "tom");
	    // properties.put("password", "secret");
	    //
	    // final Connection conn3 = DriverManager.getConnection(dbURL3,
	    // properties);
	    // if (conn3 != null) {
	    // System.out.println("Connected to database #3");
	    // }

	} catch (final SQLException ex) {
	    ex.printStackTrace();
	} finally {
	    try {
		if (conn != null) {
		    DriverManager.getConnection("jdbc:derby:;shutdown=true");
		    conn.close();
		    System.out.println("Connection closed");
		}
	    } catch (final SQLException sqlExcept) {

	    }
	}
    }
}