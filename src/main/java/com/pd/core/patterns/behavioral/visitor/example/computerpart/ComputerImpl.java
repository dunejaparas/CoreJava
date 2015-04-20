package com.pd.core.patterns.behavioral.visitor.example.computerpart;

public class ComputerImpl implements IComputerPart {

    IComputerPart[] parts;

    public ComputerImpl() {
	parts = new IComputerPart[] { new MouseImpl(), new KeyboardImpl(), new MonitorImpl() };
    }

    @Override
    public void accept(final IComputerPartVisitor computerPartVisitor) {
	for (final IComputerPart part : parts) {
	    part.accept(computerPartVisitor);
	}
	computerPartVisitor.visit(this);
    }
}