package com.pd.core.prepare.output;

public class HorseTest {
    public static void main(final String[] args) {
	class Horse {
	    public String name; /* Line 7 */

	    public Horse(final String s) {
		name = s;
	    }
	} /* class Horse ends */

	final Object obj = new Horse("Zippo"); /* Line 13 */
	final Horse h = (Horse) obj; /* Line 14 */
	System.out.println(h.name);
    }
}