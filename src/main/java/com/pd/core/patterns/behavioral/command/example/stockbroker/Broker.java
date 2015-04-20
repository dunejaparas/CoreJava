package com.pd.core.patterns.behavioral.command.example.stockbroker;

import java.util.ArrayList;
import java.util.List;

public class Broker {
    private final List<IOrder> orderList = new ArrayList<IOrder>();

    public void takeOrder(final IOrder order) {
	orderList.add(order);
    }

    public void placeOrders() {

	for (final IOrder order : orderList) {
	    order.execute();
	}
	orderList.clear();
    }
}