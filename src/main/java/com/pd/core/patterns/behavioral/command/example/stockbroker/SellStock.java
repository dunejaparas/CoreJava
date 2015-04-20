package com.pd.core.patterns.behavioral.command.example.stockbroker;


public class SellStock implements IOrder {
    private final StockTrade abcStock;

    public SellStock(final StockTrade abcStock) {
	this.abcStock = abcStock;
    }

    @Override
    public void execute() {
	abcStock.sell();
    }
}