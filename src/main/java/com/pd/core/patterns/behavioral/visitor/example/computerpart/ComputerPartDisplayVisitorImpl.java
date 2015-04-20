package com.pd.core.patterns.behavioral.visitor.example.computerpart;

public class ComputerPartDisplayVisitorImpl implements IComputerPartVisitor {

    @Override
    public void visit(final ComputerImpl computer) {
	System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(final MouseImpl mouse) {
	System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(final KeyboardImpl keyboard) {
	System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(final MonitorImpl monitor) {
	System.out.println("Displaying Monitor.");
    }
}