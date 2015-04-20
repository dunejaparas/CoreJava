package com.pd.core.patterns.behavioral.strategy.example.payment;

public class Item {

    private final String upcCode;
    private final int price;

    public Item(final String upc, final int cost) {
	this.upcCode = upc;
	this.price = cost;
    }

    public String getUpcCode() {
	return upcCode;
    }

    public int getPrice() {
	return price;
    }

}