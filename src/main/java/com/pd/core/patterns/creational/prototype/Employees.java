package com.pd.core.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {

    private final List<String> empList;

    public Employees() {
	empList = new ArrayList<String>();
    }

    public Employees(final List<String> list) {
	this.empList = list;
    }

    public void loadData() {
	// read all employees from database and put into the list
	empList.add("Pankaj");
	empList.add("Raj");
	empList.add("David");
	empList.add("Lisa");
    }

    public List<String> getEmployeesList() {
	return empList;
    }

    // Notice that the clone method is overridden to provide a deep copy of the
    // employees list.
    @Override
    public Object clone() throws CloneNotSupportedException {
	final List<String> temp = new ArrayList<String>();
	for (final String s : this.getEmployeesList()) {
	    temp.add(s);
	}
	return new Employees(temp);
    }

}