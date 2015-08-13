package com.pd.core.prepare.output;

class Q207 {
    public static void main(final String[] args) {
	final int i1 = 5;
	final int i2 = 6;
	final String s21 = "7";
	System.out.println(i1 + i2 + s21); /* Line 8 */
	System.out.println(s21 + i1 + i2); /* Line 8 */

	final String s1 = "abc";
	String s2 = "def";
	final String s3 = s2; /* Line 7 */
	s2 = "ghi";
	System.out.println(s1 + s2 + s3);
    }
}
