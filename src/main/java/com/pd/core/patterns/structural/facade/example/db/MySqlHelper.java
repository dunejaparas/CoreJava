package com.pd.core.patterns.structural.facade.example.db;

import java.sql.Connection;

public class MySqlHelper {

    public static Connection getMySqlDBConnection() {
	// get MySql DB connection using connection parameters
	return null;
    }

    public void generateMySqlPDFReport(final String tableName, final Connection con) {
	// get data from table and generate pdf report
    }

    public void generateMySqlHTMLReport(final String tableName, final Connection con) {
	// get data from table and generate pdf report
    }
}
