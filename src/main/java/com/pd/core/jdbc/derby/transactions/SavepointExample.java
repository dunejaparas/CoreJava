package com.pd.core.jdbc.derby.transactions;

import java.sql.*;

import com.pd.core.jdbc.derby.DerbyUtils;
import com.pd.core.jdbc.derby.StringBundle;

public class SavepointExample {

    @SuppressWarnings("unused")
    public static void main(final String[] args) {
	Connection conn = null;
	Statement stmt = null;
	try {
	    // STEP 2: Register JDBC driver
	    Class.forName(StringBundle.JDBC_EMBEDDED_DRIVER);

	    // STEP 3: Open a connection
	    System.out.println("Connecting to database...");
	    conn = DriverManager.getConnection(StringBundle.DB_URL_EMBEDDED);
	    createTableAndInsert(conn);
	    // STEP 4: Set auto commit as false.
	    conn.setAutoCommit(false);

	    // STEP 5: Execute a query to delete statment with
	    // required arguments for RS example.
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    // STEP 6: Now list all the available records.
	    String sql = "SELECT id, firstname, lastname, age FROM Employees";
	    ResultSet rs = stmt.executeQuery(sql);
	    System.out.println("List result set for reference....");
	    printRs(rs);

	    // STEP 7: delete rows having ID grater than 104
	    // But save point before doing so.
	    final Savepoint savepoint1 = conn.setSavepoint("ROWS_DELETED_1");
	    System.out.println("Deleting row....1");
	    String SQL = "DELETE FROM Employees " + "WHERE ID = 110";
	    stmt.executeUpdate(SQL);
	    // oops... we deleted too wrong employees!
	    // STEP 8: Rollback the changes afetr save point 2.
	    conn.rollback(savepoint1);

	    // STEP 9: delete rows having ID grater than 104
	    // But save point before doing so.
	    final Savepoint savepoint2 = conn.setSavepoint("ROWS_DELETED_2");
	    System.out.println("Deleting row....2");
	    SQL = "DELETE FROM Employees " + "WHERE ID = 95";
	    stmt.executeUpdate(SQL);

	    // STEP 10: Now list all the available records.
	    sql = "SELECT id, firstname, lastname, age FROM Employees";
	    rs = stmt.executeQuery(sql);
	    System.out.println("List result set for reference....");
	    printRs(rs);

	    // STEP 10: Clean-up environment
	    rs.close();
	    stmt.close();
	    conn.commit();
	    conn.close();
	} catch (final SQLException se) {
	    // Handle errors for JDBC
	    se.printStackTrace();
	    // If there is an error then rollback the changes.
	    System.out.println("Rolling back data here....");
	    try {
		if (conn != null) {
		    conn.rollback();
		}
	    } catch (final SQLException se2) {
		se2.printStackTrace();
	    }// end try

	} catch (final Exception e) {
	    // Handle errors for Class.forName
	    e.printStackTrace();
	} finally {
	    // finally block used to close resources
	    try {
		if (stmt != null) {
		    stmt.close();
		}
	    } catch (final SQLException se2) {
	    }// nothing we can do
	    try {
		if (conn != null) {
		    conn.close();
		}
	    } catch (final SQLException se) {
		se.printStackTrace();
	    }// end finally try
	}// end try
	System.out.println("Goodbye!");
    }// end main

    public static void printRs(final ResultSet rs) throws SQLException {
	// Ensure we start with first row

	while (rs.next()) {
	    // Retrieve by column name
	    final int id = rs.getInt("id");
	    final int age = rs.getInt("age");
	    final String first = rs.getString("firstname");
	    final String last = rs.getString("lastname");

	    // Display values
	    System.out.print("ID: " + id);
	    System.out.print(", Age: " + age);
	    System.out.print(", First: " + first);
	    System.out.println(", Last: " + last);
	}
	System.out.println();
    }// end printRs()

    private static void createTableAndInsert(final Connection connection) throws SQLException {
	DerbyUtils.executeDDL(connection, "create table Employees ( id int not null, age int not null, firstname varchar (255), lastname varchar (255) )");

	final PreparedStatement prepareStatement = DerbyUtils.prepareStatement(connection, "INSERT INTO Employees VALUES (?,?,?,?)");

	final String[][] values = { { "100", "18", "Zara", "Ali" }, { "101", "25", "Mahnaz", "Fatma" }, { "102", "30", "Zaid", "Khan" }, { "103", "28", "Sumit", "Mittal" } };
	for (final String[] value : values) {
	    prepareStatement.setString(1, value[0]);
	    prepareStatement.setString(2, value[1]);
	    prepareStatement.setString(3, value[2]);
	    prepareStatement.setString(4, value[3]);
	    prepareStatement.addBatch();
	}
	final int[] executeUpdate = prepareStatement.executeBatch();
	int count = 0;
	for (final int update : executeUpdate) {
	    count += update;
	}
	System.out.println(String.format("execute Batch Update: %d rows created", count));
    }
}// end JDBCExample