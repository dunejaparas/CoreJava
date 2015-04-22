package com.pd.core.jdbc.derby;

public class SimpleJDBC {
    public static void main(final String args[]) {
	try {

	    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	    System.out.println("yippie!");
	} catch (final ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }
}
