package com.pd.core.patterns.behavioral.visitor.example.computerpart;

public interface IComputerPartVisitor {
    public void visit(ComputerImpl computer);

    public void visit(MouseImpl mouse);

    public void visit(KeyboardImpl keyboard);

    public void visit(MonitorImpl monitor);
}
