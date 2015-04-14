package com.pd.core.patterns.structural.flyweight.example.wargame;

public class SoldierImp implements ISoldier {

    /**
     * Intrinsic State maintained by flyweight implementation Solider Shape (
     * graphical represetation) how to display the soldier is up to the
     * flyweight implementation
     */
    private Object soldierGraphicalRepresentation;

    /**
     * Note that this method accepts soldier location Soldier Location is
     * Extrinsic and no reference to previous location or new location is
     * maintained inside the flyweight implementation
     */
    @Override
    public void moveSoldier(final int previousLocationX, final int previousLocationY, final int newLocationX,
	    final int newLocationY) {

	// delete soldier representation from previous location
	// then render soldier representation in new location
    }

}
