package com.pd.core.patterns.structural.facade.example.db;

import java.sql.Connection;

public class HelperFacade {

    public static void generateReport(final DBTypes dbType, final ReportTypes reportType, final String tableName) {
	Connection con = null;
	switch (dbType) {
	case MYSQL:
	    con = MySqlHelper.getMySqlDBConnection();
	    final MySqlHelper mySqlHelper = new MySqlHelper();
	    switch (reportType) {
	    case HTML:
		mySqlHelper.generateMySqlHTMLReport(tableName, con);
		break;
	    case PDF:
		mySqlHelper.generateMySqlPDFReport(tableName, con);
		break;
	    }
	    break;
	case ORACLE:
	    con = OracleHelper.getOracleDBConnection();
	    final OracleHelper oracleHelper = new OracleHelper();
	    switch (reportType) {
	    case HTML:
		oracleHelper.generateOracleHTMLReport(tableName, con);
		break;
	    case PDF:
		oracleHelper.generateOraclePDFReport(tableName, con);
		break;
	    }
	    break;
	}

    }

    public static enum DBTypes {
	MYSQL, ORACLE;
    }

    public static enum ReportTypes {
	HTML, PDF;
    }
}