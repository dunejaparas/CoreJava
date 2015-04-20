package com.pd.core.patterns.behavioral.strategy.example.payment;

public class ShoppingCartDemo {
    public static void main(final String[] args) {
	final ShoppingCart cart = new ShoppingCart();

	final Item item1 = new Item("1234", 10);
	final Item item2 = new Item("5678", 40);

	cart.addItem(item1);
	cart.addItem(item2);

	// pay by paypal
	cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));

	// pay by credit card
	cart.pay(new CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786", "12/15"));
    }
}
