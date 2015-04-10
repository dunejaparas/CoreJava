package com.pd.core.patterns.structural.composite.example.employee;

public class CompositePatternDemo {
    public static void main(final String[] args) {
	final Employee emp1 = new Developer("John", 10000);
	final Employee emp2 = new Developer("David", 15000);
	final Employee manager1 = new Manager("Daniel", 25000);
	manager1.add(emp1);
	manager1.add(emp2);
	final Employee emp3 = new Developer("Michael", 20000);
	final Manager generalManager = new Manager("Mark", 50000);
	generalManager.add(emp3);
	generalManager.add(manager1);
	generalManager.print();
    }
}
