package com.pd.core.jdbc.derby.resultset;

import java.sql.*;

import com.pd.core.jdbc.derby.DerbyUtils;
import com.pd.core.jdbc.derby.StringBundle;

public class BasicResultSet {

    /*
     * ResultSet Type, Concurrency and Holdability
     * 
     * 
     * while(result.next()) { // ... get column values from this record }
     * 
     * As you can see, the next() method is actually called before the first
     * record is accessed. That means, that the ResultSet starts out pointing
     * before the first record. Once next() has been called once, it points at
     * the first record.
     * 
     * Similarly, when next() is called and returns false, the ResultSet is
     * actually pointing after the last record.
     * 
     * When you create a ResultSet there are three attributes you can set. These
     * are: 1. Type 2. Concurrency 3. Holdability
     */
    private Connection connection = null;
    private PreparedStatement prepareStatement = null;

    public static void main(final String args[]) {
	new BasicResultSet().begin(true);
    }

    void begin(final boolean dropTable) {
	try {
	    connection = DerbyUtils.loadDbDriverAndCreateConnection();
	    DerbyUtils.executeDDL(connection, StringBundle.SQL_CREATE_TABLE_SQL_EatingJoints);
	    prepareStatement = DerbyUtils.prepareStatement(connection, StringBundle.SQL_PREPARED_STATEMENT_INSERT);
	    // use prepared insert statement
	    batchUpdate();
	    runSelectQuery(StringBundle.SQL_SELECT_ALL_FROM_EATING_JOINTS);
	    if (dropTable) {
		dropTable();
	    }
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    DerbyUtils.closeConnection(connection);
	}

    }

    public void dropTable() {
	DerbyUtils.executeDDL(connection, StringBundle.SQL_DROP_TABLE_SQL_EatingJoints);
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

	final String[][] values = { { "Chilli Masala", "Stockholm, Sweden" }, { "Sean", "Athlone Castle, Ireland" }, { "Max Burgers", "Stockholm" }, { "Piano Bar", "Athlone" },
		{ "More", "More" } };
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

	    /*
	     * As you can see, the next() method is actually called before the
	     * first record is accessed. That means, that the ResultSet starts
	     * out pointing before the first record. Once next() has been called
	     * once, it points at the first record.
	     *
	     * Similarly, when next() is called and returns false, the ResultSet
	     * is actually pointing after the last record.
	     */
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

    public Connection getConnection() {
	return connection;
    }

}
