package com.pd.core.patterns.behavioral.command.example.stockbroker;


public class BuyStock implements IOrder {
    private final StockTrade abcStock;

    public BuyStock(final StockTrade abcStock) {
	this.abcStock = abcStock;
    }

    @Override
    public void execute() {
	abcStock.buy();
    }
}