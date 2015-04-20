package com.pd.core.patterns.behavioral.strategy.example.payment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Notice that payment method of shopping cart requires payment algorithm as
 * argument and doesn’t store it anywhere as instance variable.
 *
 */
public class ShoppingCart {

    // List of items
    List<Item> items;

    public ShoppingCart() {
	this.items = new ArrayList<Item>();
    }

    public void addItem(final Item item) {
	this.items.add(item);
    }

    public void removeItem(final Item item) {
	this.items.remove(item);
    }

    public int calculateTotal() {
	int sum = 0;
	for (final Item item : items) {
	    sum += item.getPrice();
	}
	return sum;
    }

    public void pay(final PaymentStrategy paymentMethod) {
	final int amount = calculateTotal();
	paymentMethod.pay(amount);
    }
}