package com.pd.core.patterns.behavioral.command.example.stockbroker;


public class CommandPatternDemo {
    public static void main(final String[] args) {
	final StockTrade abcStock = new StockTrade();

	final BuyStock buyStockOrder = new BuyStock(abcStock);
	final SellStock sellStockOrder = new SellStock(abcStock);

	final Broker broker = new Broker();
	broker.takeOrder(buyStockOrder);
	broker.takeOrder(sellStockOrder);

	broker.placeOrders();
    }
}