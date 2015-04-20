package com.pd.core.patterns.behavioral.command.example.stockbroker;

public class StockTrade {
    private final String name = "ABC";
    private final int quantity = 10;

    public void buy() {
	System.out.println("Stock [ Name: " + name + ",Quantity: " + quantity + " ] bought");
    }

    public void sell() {
	System.out.println("Stock [ Name: " + name + ",Quantity: " + quantity + " ] sold");
    }
}
