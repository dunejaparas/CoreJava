package com.pd.core.jdbc.derby.resultset;

import java.sql.*;

import com.pd.core.jdbc.derby.DerbyUtils;
import com.pd.core.jdbc.derby.StringBundle;

public class UpdateResultSet {
    /*
     * ResultSet Concurrency
     *
     * The ResultSet concurrency determines whether the ResultSet can be
     * updated, or only read.
     *
     * Some databases and JDBC drivers support that the ResultSet is updated,
     * but not all databases and JDBC drivers do. The
     * DatabaseMetaData.supportsResultSetConcurrency(int concurrency) method
     * returns true or false depending on whether the given concurrency mode is
     * supported or not. The DatabaseMetaData class is covered in a later text.
     *
     * A ResultSet can have one of two concurrency levels:
     *
     * ResultSet.CONCUR_READ_ONLY ResultSet.CONCUR_UPDATABLE CONCUR_READ_ONLY
     * means that the ResultSet can only be read.
     *
     * CONCUR_UPDATABLE means that the ResultSet can be both read and updated.
     */

    /*
     * Updating a ResultSet
     * 
     * If a ResultSet is updatable, you can update the columns of each row in
     * the ResultSet. You do so using the many updateXXX() methods. For
     * instance:
     * 
     * result.updateString ("name" , "Alex"); result.updateInt ("age" , 55);
     * result.updateBigDecimal ("coefficient", new BigDecimal("0.1323");
     * result.updateRow(); You can also update a column using column index
     * instead of column name. Here is an example:
     * 
     * result.updateString (1, "Alex"); result.updateInt (2, 55);
     * result.updateBigDecimal (3, new BigDecimal("0.1323"); result.updateRow();
     * Notice the updateRow() call. It is when updateRow() is called that the
     * database is updated with the values of the row. Id you do not call this
     * method, the values updated in the ResultSet are never sent to the
     * database. If you call updateRow() inside a transaction, the data is not
     * actually committed to the database until the transaction is committed.
     * 
     * Inserting Rows into a ResultSet
     * 
     * If the ResultSet is updatable it is also possible to insert rows into it.
     * You do so by:
     * 
     * call ResultSet.moveToInsertRow() update row column values call
     * ResultSet.insertRow() Here is an example:
     * 
     * result.moveToInsertRow(); result.updateString (1, "Alex");
     * result.updateInt (2, 55); result.updateBigDecimal (3, new
     * BigDecimal("0.1323"); result.insertRow();
     * 
     * result.beforeFirst(); The row pointed to after calling moveToInsertRow()
     * is a special row, a buffer, which you can use to build up the row until
     * all column values has been set on the row.
     * 
     * Once the row is ready to be inserted into the ResultSet, call the
     * insertRow() method.
     * 
     * After inserting the row the ResultSet still pointing to the insert row.
     * However, you cannot be certain what will happen if you try to access it,
     * once the row has been inserted. Therefore you should move the ResultSet
     * to a valid position after inserting the new row. If you need to insert
     * another row, explicitly call moveToInsertRow() to signal this to the
     * ResultSet.
     */
    private Connection connection = null;
    private PreparedStatement prepareStatement = null;

    public static void main(final String args[]) {
	new UpdateResultSet().begin(true);
    }

    void begin(final boolean dropTable) {
	try {
	    connection = DerbyUtils.loadDbDriverAndCreateConnection();
	    DerbyUtils.executeDDL(connection, StringBundle.SQL_CREATE_TABLE_SQL_EatingJoints);
	    prepareStatement = DerbyUtils.prepareStatement(connection, StringBundle.SQL_PREPARED_STATEMENT_INSERT, ResultSet.CONCUR_UPDATABLE);
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
	    final Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
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

		if ("More".equals(restName)) {
		    DerbyUtils.getResultSetConcurrencyInfo(results);
		    results.updateString("name", "Semla Bun");
		    results.updateString("city", "Sweden");
		    results.updateRow();
		    connection.commit();
		    System.out.println("New Values");
		    final String restName2 = results.getString(2);
		    final String cityName2 = results.getString(3);
		    System.out.println(id + "\t\t" + restName2 + "\t\t" + cityName2);
		    results.beforeFirst();
		    System.out.println("Returning cursor to move to first record");
		}
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
