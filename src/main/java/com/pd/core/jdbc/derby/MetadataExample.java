package com.pd.core.jdbc.derby;

import java.sql.*;

public class MetadataExample {

    private static Connection conn = null;
    private static Statement stmt = null;
    private DatabaseMetaData databaseMetaData;

    public static void main(final String[] args) {
	try {
	    new MetadataExample().begin();
	} catch (final Exception e) {
	    e.printStackTrace();
	}
    }

    private void begin() throws Exception {
	try {

	    // This hangs DerbyUtils.startDBProgramatically();
	    createConnection();
	    getDbMetadata();

	    getDbInfo();
	    listTables();

	    getTableInfo();
	    runSelectQuery();
	    shutdownConnection();
	    // This hangs DerbyUtils.shutdownDBProgramatically();

	} catch (final InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
	    e.printStackTrace();
	} finally {

	}

    }

    private void getTableInfo() throws SQLException {
	final String catalog = null;
	final String schemaPattern = null;
	final String tableNamePattern = "RESTAURANTS";
	final String columnNamePattern = null;

	final ResultSet result = databaseMetaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);

	while (result.next()) {
	    final String columnName = result.getString(4);
	    final int columnType = result.getInt(5);
	    System.out.println("Column name:'" + columnName + "' , column type\t\t:" + columnType);
	}

    }

    private void listTables() throws SQLException {
	final String catalog = null;
	final String schemaPattern = null;
	final String tableNamePattern = null;
	final String[] types = null;

	final ResultSet result = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);

	while (result.next()) {
	    final String tableName = result.getString(3);
	    System.out.println("tableName \t\t:" + tableName);
	}
    }

    private void getDbMetadata() throws SQLException {
	databaseMetaData = conn.getMetaData();
    }

    private void getDbInfo() throws SQLException {
	final int majorVersion = databaseMetaData.getDatabaseMajorVersion();
	System.out.println("majorVersion \t\t:" + majorVersion);

	final int minorVersion = databaseMetaData.getDatabaseMinorVersion();
	System.out.println("minorVersion \t\t:" + minorVersion);

	final String productName = databaseMetaData.getDatabaseProductName();
	System.out.println("productName \t\t:" + productName);

	final String productVersion = databaseMetaData.getDatabaseProductVersion();
	System.out.println("productVersion \t\t:" + productVersion);

	final int driverMajorVersion = databaseMetaData.getDriverMajorVersion();
	System.out.println("driverMajorVersion \t\t:" + driverMajorVersion);

	final int driverMinorVersion = databaseMetaData.getDriverMinorVersion();
	System.out.println("driverMinorVersion \t\t:" + driverMinorVersion);

	final boolean supportsBatch = databaseMetaData.supportsBatchUpdates();
	System.out.println("supportsBatch \t\t:" + supportsBatch);
	System.out.println("\n\n***********************************");

    }

    private static void runSelectQuery() {
	try {
	    stmt = conn.createStatement();
	    final ResultSet results = stmt.executeQuery("select * from restaurants");
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

    private void createConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	Class.forName(StringBundle.JDBC_CLIENT_DRIVER).newInstance();
	// Get a connection
	conn = DriverManager.getConnection(StringBundle.DB_URL);
	if (conn != null) {
	    System.out.println("Connected to persistence database, not in memory");
	}
    }

    private void shutdownConnection() throws SQLException {
	if (stmt != null) {
	    stmt.close();
	    System.out.println("Closed open statement");
	}

    }
}
