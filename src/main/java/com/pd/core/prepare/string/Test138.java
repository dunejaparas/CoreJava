package com.pd.core.prepare.string;

public class Test138 {
    public static void stringReplace(String text) {
	text = text.replace('j', 'c'); /* Line 5 */
    }

    public static void bufferReplace(StringBuffer text) {
	text = text.append("c"); /* Line 9 */
    }

    public static void main(final String args[]) {
	final String textString = new String("java");
	final StringBuffer textBuffer = new StringBuffer("java"); /* Line 14 */
	stringReplace(textString);
	bufferReplace(textBuffer);
	System.out.println(textString + textBuffer);
    }
}