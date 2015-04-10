package com.pd.core.patterns.structural.composite.example.employee;

public class Developer implements Employee {

    private final String name;
    private final double salary;

    public Developer(final String name, final double salary) {
	this.name = name;
	this.salary = salary;
    }

    @Override
    public void add(final Employee employee) {
	// this is leaf node so this method is not applicable to this class.
    }

    @Override
    public Employee getChild(final int i) {
	// this is leaf node so this method is not applicable to this class.
	return null;
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
    }

    @Override
    public void remove(final Employee employee) {
	// this is leaf node so this method is not applicable to this class.
    }

}