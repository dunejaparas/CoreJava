package com.pd.core.prepare.output;

public class ObjComp{
    public static void main(final String [] args )
    {
	int result = 0;
	final ObjComp oc = new ObjComp();
	final Object o = oc;

	if (o == oc) {
	    result = 1;
	}
	if (o != oc) {
	    result = result + 10;
	}
	if (o.equals(oc) ) {
	    result = result + 100;
	}
	if (oc.equals(o) ) {
	    result = result + 1000;
	}

	System.out.println("result = " + result);
    }


}