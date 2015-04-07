package com.pd.core.patterns.creational.prototype;

import java.util.List;

public class CreateUsingPrototypePattern {

    public static void main(final String[] args) throws CloneNotSupportedException {
	final Employees emps = new Employees();
	emps.loadData();

	// Use the clone method to get the Employee object
	final Employees empsNew = (Employees) emps.clone();
	final Employees empsNew1 = (Employees) emps.clone();
	final List<String> list = empsNew.getEmployeesList();
	list.add("John");
	final List<String> list1 = empsNew1.getEmployeesList();
	list1.remove("Pankaj");

	System.out.println("emps List: " + emps.getEmployeesList());
	System.out.println("empsNew List: " + list);
	System.out.println("empsNew1 List: " + list1);
    }

}