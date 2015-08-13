package com.pd.core.prepare.lang;

import java.util.*;

public class VectorElements {
    public static void main(final String[] args) {
	final Object x = new Vector().elements();
	System.out.print((x instanceof Enumeration) + ",");
	System.out.print((x instanceof Iterator) + ",");
	System.out.print(x instanceof ListIterator);
    }
}
