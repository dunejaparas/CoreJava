package com.pd.core.patterns.behavioral.visitor.example.shoppingcart;

public class Fruit implements IItemElement {

    private final int pricePerKg;
    private final int weight;
    private final String name;

    public Fruit(final int priceKg, final int wt, final String nm) {
	this.pricePerKg = priceKg;
	this.weight = wt;
	this.name = nm;
    }

    public int getPricePerKg() {
	return pricePerKg;
    }

    public int getWeight() {
	return weight;
    }

    public String getName() {
	return this.name;
    }

    /**
     * Notice the implementation of accept() method in concrete classes, its
     * calling visit() method of Visitor and passing itself as argument.
     */
    @Override
    public int accept(final IShoppingCartVisitor visitor) {
	return visitor.visit(this);
    }

}