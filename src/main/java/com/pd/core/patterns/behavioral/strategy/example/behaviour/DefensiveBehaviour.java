package com.pd.core.patterns.behavioral.strategy.example.behaviour;

public class DefensiveBehaviour implements IBehaviour {
    @Override
    public int moveCommand() {
	System.out.println("\tDefensive Behaviour: if find another robot run from it");
	return -1;
    }
}
