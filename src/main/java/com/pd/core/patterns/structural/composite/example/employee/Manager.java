package com.pd.core.patterns.structural.composite.example.employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager implements Employee {

    private final String name;
    private final double salary;

    public Manager(final String name, final double salary) {
	this.name = name;
	this.salary = salary;
    }

    List<Employee> employees = new ArrayList<Employee>();

    @Override
    public void add(final Employee employee) {
	employees.add(employee);
    }

    @Override
    public Employee getChild(final int i) {
	return employees.get(i);
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public double getSalary() {
	return salary;
    }

    @Override
    public void print() {
	System.out.println("-------------");
	System.out.println("Name =" + getName());
	System.out.println("Salary =" + getSalary());
	System.out.println("-------------");

	final Iterator<Employee> employeeIterator = employees.iterator();
	while (employeeIterator.hasNext()) {
	    final Employee employee = employeeIterator.next();
	    employee.print();
	}
    }

    @Override
    public void remove(final Employee employee) {
	employees.remove(employee);
    }

}