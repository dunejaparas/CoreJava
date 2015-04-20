package com.pd.core.patterns.behavioral.visitor.example.computerpart;

public interface IComputerPart {

    public void accept(IComputerPartVisitor computerPartVisitor);

}
