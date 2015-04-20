package com.pd.core.patterns.mvc;

/**
 *
 * Create Model.
 * 
 * 
 *
 */
public class Student {

    private String rollNo;
    private String name;

    public String getRollNo() {
	return rollNo;
    }

    public void setRollNo(final String rollNo) {
	this.rollNo = rollNo;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }
}