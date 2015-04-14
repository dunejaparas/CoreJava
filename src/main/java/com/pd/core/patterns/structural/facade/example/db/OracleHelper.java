package com.pd.core.patterns.structural.facade.example.db;

import java.sql.Connection;

public class OracleHelper {
    public static Connection getOracleDBConnection() {
	// get Oracle DB connection using connection parameters
	return null;
    }

    public void generateOraclePDFReport(final String tableName, final Connection con) {
	// get data from table and generate pdf report
    }

    public void generateOracleHTMLReport(final String tableName, final Connection con) {
	// get data from table and generate pdf report
    }
}
