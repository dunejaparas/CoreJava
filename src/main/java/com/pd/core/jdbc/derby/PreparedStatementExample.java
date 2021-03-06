package com.pd.core.jdbc.derby;

import java.sql.*;

public class PreparedStatementExample {

    /*
     * Q: What is the difference between execute, executeQuery, executeUpdate?
     * A:
     *
     * boolean execute(): Executes the any kind of SQL statement.
     *
     * RETURNS: true if the first result is a ResultSet object; false if the
     * first result is an update count or there is no result
     *
     *
     *
     * ResultSet executeQuery(): This is used generally for reading the content
     * of the database. The output will be in the form of ResultSet. Generally
     * SELECT statement is used.
     *
     * RETURNS: a ResultSet object that contains the data produced by the query;
     * never null
     *
     *
     *
     * int executeUpdate(): This is generally used for altering the databases.
     * Generally DROP TABLE or DATABASE, INSERT into TABLE, UPDATE TABLE, DELETE
     * from TABLE statements will be used in this. The output will be in the
     * form of int which denotes the number of rows affected by the query.
     *
     * RETURNS: either (1) the row count for SQL Data Manipulation Language
     * (DML) statements or (2) 0 for SQL statements that return nothing
     */
    private Connection connection = null;
    private PreparedStatement prepareStatement = null;

    public static void main(final String args[]) {
	new PreparedStatementExample().begin();
    }

    private void begin() {
	try {
	    connection = DerbyUtils.loadDbDriverAndCreateConnection();
	    DerbyUtils.executeDDL(connection, StringBundle.SQL_CREATE_TABLE_SQL_EatingJoints);
	    prepareStatement = DerbyUtils.prepareStatement(connection, StringBundle.SQL_PREPARED_STATEMENT_INSERT);
	    // use prepared insert statement
	    insertValue();
	    batchUpdate();
	    runSelectQuery(StringBundle.SQL_SELECT_ALL_FROM_EATING_JOINTS);
	    DerbyUtils.executeDDL(connection, StringBundle.SQL_DROP_TABLE_SQL_EatingJoints);
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    DerbyUtils.closeConnection(connection);
	}

    }

    /*
     * java.sql.SQLException:
     *
     * if all variables arent initialized: At least one parameter to the current
     * statement is uninitialized.
     */

    private void insertValue() throws SQLException {
	prepareStatement.setString(1, "Chilli Masala");
	prepareStatement.setString(2, "Stockholm, Sweden");
	final int executeUpdate = prepareStatement.executeUpdate();
	System.out.println("executeUpdate:" + executeUpdate + " rows created");
    }

    /*
     * JDBC - Batch Processing JDBC
     * 
     * Drivers are not required to support this feature. You should use the
     * DatabaseMetaData.supportsBatchUpdates() method to determine if the target
     * database supports batch update processing. The method returns true if
     * your JDBC driver supports this feature
     */
    private void batchUpdate() throws SQLException {

	final boolean supportsBatch = connection.getMetaData().supportsBatchUpdates();
	System.out.println("\n\nDB Metadata :: supportsBatch \t:" + supportsBatch + "\n\n");

	final String[][] values = { { "Sean", "Athlone Castle, Ireland" }, { "Max Burgers", "Stockholm" }, { "Piano Bar", "Athlone" }, { "More", "More" } };
	for (final String[] value : values) {
	    prepareStatement.setString(1, value[0]);
	    prepareStatement.setString(2, value[1]);
	    prepareStatement.addBatch();
	}
	final int[] executeUpdate = prepareStatement.executeBatch();
	int count = 0;
	for (final int update : executeUpdate) {
	    count += update;
	}
	System.out.println(String.format("execute Batch Update: %d rows created", count));
    }

    // Move this back to Prepared Statement, since the resultset is related to
    // structure of table
    private void runSelectQuery(final String query) {
	try {
	    final Statement stmt = connection.createStatement();
	    final ResultSet results = stmt.executeQuery(query);
	    final ResultSetMetaData rsmd = results.getMetaData();
	    final int numberCols = rsmd.getColumnCount();
	    for (int i = 1; i <= numberCols; i++) {
		// print Column Names
		System.out.print(rsmd.getColumnLabel(i) + "\t\t");
	    }

	    System.out.println("\n-------------------------------------------------");

	    while (results.next()) {
		// final String id = results.getString(1);
		final int id = results.getInt(1);

		// Invalid character string format for type int.
		// if final String is assigned to int
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
}
