package com.pd.core.patterns.structural.flyweight.example.wargame;

/**
 * Flyweight Factory
 */
public class SoldierFactory {

    /**
     * Pool for one soldier only if there are more soldier types this can be an
     * array or list or better a HashMap
     *
     */
    private static ISoldier SOLDIER;

    /**
     * getFlyweight
     *
     * @return
     */
    public static ISoldier getSoldier() {

	// this is a singleton
	// if there is no soldier
	if (SOLDIER == null) {

	    // create the soldier
	    SOLDIER = new SoldierImp();
	}

	// return the only soldier reference
	return SOLDIER;
    }
}