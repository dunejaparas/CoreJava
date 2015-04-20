package com.pd.core.patterns.behavioral.visitor.example.computerpart;

public class VisitorPatternDemo {
    public static void main(final String[] args) {

	final IComputerPart computer = new ComputerImpl();
	computer.accept(new ComputerPartDisplayVisitorImpl());
    }
}
