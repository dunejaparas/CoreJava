package com.pd.core.jdbc.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

	try {
	    // java -jar derbyrun.jar server start
	    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

	    final Connection conn3 = DriverManager.getConnection("jdbc:derby://localhost:1527/derbyDB;create=true");
	    if (conn3 != null) {
		System.out.println("Connected to persistence database, not in memory");
	    }
	    final Statement stmt = conn3.createStatement();
	    stmt.execute("create table restaurants(id integer, name varchar(20), city varchar(50))");
	    stmt.execute("drop table restaurants");
	    stmt.close();
	    // java -jar derbyrun.jar server shutdown
	} catch (final SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
	    ex.printStackTrace();
	} finally {
	}
    }
}