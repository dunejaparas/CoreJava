package com.pd.core.prepare.collections;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetOutput {

    public static void main(final String[] args) {

	final TreeSet map = new TreeSet();
	map.add("one");
	map.add("two");
	map.add("three");
	map.add("four");
	map.add("one");
	final Iterator it = map.iterator();
	while (it.hasNext() )
	{
	    System.out.print( it.next() + " " );
	}
    }


}