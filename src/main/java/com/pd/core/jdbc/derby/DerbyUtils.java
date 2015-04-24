package com.pd.core.jdbc.derby;

import java.sql.SQLException;

public class DerbyUtils {

    public DerbyUtils() {
	// empty constructor -- helper class
    }

    public static boolean tableAlreadyExists(final SQLException e) {
	boolean exists;
	if (e.getSQLState().equals("X0Y32")) {
	    System.out.println("***		" + e.getMessage());
	    exists = true;
	} else {
	    exists = false;
	}
	return exists;
    }
}