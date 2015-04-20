package com.pd.core.patterns.behavioral.visitor.example.shoppingcart;

public class ShoppingCartDemo {

    public static void main(final String[] args) {
	final IItemElement[] items = { new Book(20, "1234"), new Fruit(15, 15, "AppleCalifornia"),
		new Book(100, "5678"), new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple") };

	final int total = calculatePrice(items);
	System.out.println("Total Cost = " + total);
    }

    private static int calculatePrice(final IItemElement[] items) {
	final IShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
	int sum = 0;
	for (final IItemElement item : items) {
	    sum = sum + item.accept(visitor);
	}
	return sum;
    }
}
