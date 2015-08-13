package com.pd.core.prepare.output;

public abstract class AbstractTest {
    public int getNum() {
	return 45;
    }

    public abstract class Bar {
	public int getNum() {
	    return 38;
	}
    }

    public static void main(final String[] args) {
	final AbstractTest t = new AbstractTest() {
	    @Override
	    public int getNum() {
		return 22;
	    }
	};
	final AbstractTest.Bar f = t.new Bar() {
	    @Override
	    public int getNum() {
		return 57;
	    }
	};

	System.out.println(f.getNum() + " " + t.getNum());
    }
}