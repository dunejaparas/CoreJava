package com.pd.core.prepare.lang;

import java.io.FileOutputStream;
import java.io.IOException;

public class MyProgramCompile {
    public static void main(final String args[]) {
	FileOutputStream out = null;
	try {
	    out = new FileOutputStream("test.txt");
	    out.write(122);
	} catch (final IOException io) {
	    System.out.println("IO Error.");
	} finally {
	    // The code will not compile if following is uncommented
	    // Unhandled exception type IOException
	    // out.close();
	}

	System.out.println(".." + (16 >> 2));
    }
}