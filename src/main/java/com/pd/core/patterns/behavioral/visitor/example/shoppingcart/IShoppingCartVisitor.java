package com.pd.core.patterns.behavioral.visitor.example.shoppingcart;

/**
 *
 * We have visit() method for different type of items in Visitor interface that
 * will be implemented by concrete visitor class.
 *
 */
public interface IShoppingCartVisitor {

    int visit(Book book);

    int visit(Fruit fruit);

}
