package com.pd.core.prepare.output;

public class SSBool {
    public static void main(final String[] args) {
	final boolean b1 = true;
	final boolean b2 = false;
	final boolean b3 = true;
	if (b1 & b2 | b2 & b3 | b2) {
	    System.out.print("ok ");
	}
	if (b1 & b2 | b2 & b3 | b2 | b1) {
	    System.out.println("dokey");
	}

	try {
	    final Float f1 = new Float("3.0");
	    final int x = f1.intValue();
	    final byte b = f1.byteValue();
	    final double d = f1.doubleValue();
	    System.out.println(x + b + d);
	} catch (final NumberFormatException e) /* Line 9 */
	{
	    System.out.println("bad number"); /* Line 11 */
	}
    }
}