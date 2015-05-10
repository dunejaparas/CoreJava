package com.pd.core.jdbc.derby.resultset;

import java.sql.*;

import com.pd.core.jdbc.derby.DerbyUtils;
import com.pd.core.jdbc.derby.StringBundle;

/*
 * ResultSet.TYPE_FORWARD_ONLY
 ResultSet.TYPE_SCROLL_INSENSITIVE
 ResultSet.TYPE_SCROLL_SENSITIVE

 ResultSet Scroll Sensitive Type (TYPE_SCROLL_SENSITIVE) :
 specifies that a resultset is scrollable in either direction and is affected by changes committed by other
 transactions or statements within the same transaction.

 Result Set Scroll Insensitive Type (TYPE_SCROLL_INSENSITIVE) :
 specifies that a resultset is scrollable in either direction but is insensitive to changes committed by other
 transactions or other statements in the same transaction.

 The default type is TYPE_FORWARD_ONLY

 TYPE_FORWARD_ONLY means that the ResultSet can only be navigated forward.
 That is, you can only move from row 1, to row 2, to row 3 etc. You cannot move backwards in the ResultSet.

 TYPE_SCROLL_INSENSITIVE means that the ResultSet can be navigated (scrolled) both forward and backwards.
 You can also jump to a position relative to the current position, or jump to an absolute position.
 The ResultSet is insensitive to changes in the underlying data source while the ResultSet is open.
 That is, if a record in the ResultSet is changed in the database by another thread or process, it
 will not be reflected in already opened ResulsSet's of this type.

 TYPE_SCROLL_SENSITIVE means that the ResultSet can be navigated (scrolled) both forward and backwards.
 You can also jump to a position relative to the current position, or jump to an absolute position.
 The ResultSet is sensitive to changes in the underlying data source while the ResultSet is open. That
 is, if a record in the ResultSet is changed in the database by another thread or process, it will be
 reflected in already opened ResulsSet's of this type.

 Navigation Methods

 The ResultSet interface contains the following navigation methods. Remember, not all methods work with all ResultSet types. What methods works depends on your database, JDBC driver, and the ResultSet type.

 Method	Description
 absolute()	Moves the ResultSet to point at an absolute position. The position is a row number passed as parameter to the absolute() method.
 afterLast()	Moves the ResultSet to point after the last row in the ResultSet.
 beforeFirst()	Moves the ResultSet to point before the first row in the ResultSet.
 first()	Moves the ResultSet to point at the first row in the ResultSet.
 last()	Moves the ResultSet to point at the last row in the ResultSet.
 next()	Moves the ResultSet to point at the next row in the ResultSet.
 previous()	Moves the ResultSet to point at the previous row in the ResultSet.
 relative()	Moves the ResultSet to point to a position relative to its current position. The relative position is passed as a parameter to the relative method, and can be both positive and negative.
 Moves the ResultSet
 The ResultSet interface also contains a set of methods you can use to inquire about the current position of the ResultSet. These are:

 Method	Description
 getRow()	Returns the row number of the current row - the row currently pointed to by the ResultSet.
 getType()	Returns the ResultSet type.
 isAfterLast()	Returns true if the ResultSet points after the last row. False if not.
 isBeforeFirst()	Returns true if the ResultSet points before the first row. False if not.
 isFirst()	Returns true if the ResultSet points at the first row. False if not.
 Finally the ResultSet interface also contains a method to update a row with database changes, if the ResultSet is sensitive to change.

 Method	Description
 refreshRow()	Refreshes the column values of that row with the latest values from the database.

 */
public class RowCount {

    private Connection connection = null;
    private PreparedStatement prepareStatement = null;

    public static void main(final String args[]) {
	new RowCount().begin(true);
    }

    private void begin(final boolean dropTable) {
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

    private void runSelectQuery(final String query) {
	try {
	    final Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	    final ResultSet resultSet = stmt.executeQuery(query);
	    System.out.println(String.format("Number of rows in result set %s", getRowCount(resultSet)));
	    resultSet.close();
	    stmt.close();
	} catch (final SQLException sqlExcept) {
	    sqlExcept.printStackTrace();
	}
    }

    private int getRowCount(final ResultSet resultSet) {
	if (resultSet == null) {
	    return 0;
	}
	try {
	    // java.sql.SQLException: This method should only be called on
	    // ResultSet objects that are scrollable (type
	    // TYPE_SCROLL_INSENSITIVE).
	    resultSet.last();
	    return resultSet.getRow();
	} catch (final SQLException exp) {
	    exp.printStackTrace();
	} finally {
	    try {
		resultSet.beforeFirst();
	    } catch (final SQLException exp) {
		exp.printStackTrace();
	    }
	}
	return 0;
    }
}
