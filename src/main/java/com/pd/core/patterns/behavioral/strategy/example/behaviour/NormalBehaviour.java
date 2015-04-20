package com.pd.core.patterns.behavioral.strategy.example.behaviour;

public class NormalBehaviour implements IBehaviour {
    @Override
    public int moveCommand() {
	System.out.println("\tNormal Behaviour: if find another robot ignore it");
	return 0;
    }
}
