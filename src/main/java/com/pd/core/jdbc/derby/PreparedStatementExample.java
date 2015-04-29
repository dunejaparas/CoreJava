package com.pd.core.jdbc.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	    DerbyUtils.runSelectQuery(connection, StringBundle.SQL_SELECT_ALL_FROM_EATING_JOINTS);
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

    private void batchUpdate() throws SQLException {
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

}
