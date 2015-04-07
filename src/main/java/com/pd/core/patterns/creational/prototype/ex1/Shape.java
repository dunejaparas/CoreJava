package com.pd.core.patterns.creational.prototype.ex1;

public abstract class Shape implements Cloneable {

    private String id;
    protected String type;

    abstract void draw();

    public String getType() {
	return type;
    }

    public String getId() {
	return id;
    }

    public void setId(final String id) {
	this.id = id;
    }

    @Override
    public Object clone() {
	Object clone = null;

	try {
	    clone = super.clone();

	} catch (final CloneNotSupportedException e) {
	    e.printStackTrace();
	}

	return clone;
    }
}