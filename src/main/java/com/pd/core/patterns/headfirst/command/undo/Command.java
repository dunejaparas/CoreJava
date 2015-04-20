package com.pd.core.patterns.headfirst.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
