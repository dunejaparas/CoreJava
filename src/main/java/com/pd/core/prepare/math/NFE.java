package com.pd.core.prepare.math;

public class NFE {
    public static void main(final String[] args) {
	String s = "42";
	try {
	    s = s.concat(".5"); /* Line 8 */
	    final double d = Double.parseDouble(s);
	    s = Double.toString(d);
	    final int x = (int) Math.ceil(Double.valueOf(s).doubleValue());
	    System.out.println(x);
	} catch (final NumberFormatException e) {
	    System.out.println("bad number");
	}
    }
}
