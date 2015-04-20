package com.pd.core.patterns.behavioral.visitor.example.shoppingcart;

public class Book implements IItemElement {

    private final int price;
    private final String isbnNumber;

    public Book(final int cost, final String isbn) {
	this.price = cost;
	this.isbnNumber = isbn;
    }

    public int getPrice() {
	return price;
    }

    public String getIsbnNumber() {
	return isbnNumber;
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