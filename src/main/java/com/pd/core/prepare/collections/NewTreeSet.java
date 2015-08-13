package com.pd.core.prepare.collections;

import java.util.TreeMap;

public class NewTreeSet extends java.util.TreeSet
{
    public static void main(final String [] args)
    {
	final java.util.TreeSet t = new java.util.TreeSet();
	t.clear();
    }
    @Override
    public void clear()
    {
	final TreeMap m = new TreeMap();
	m.clear();
    }
}