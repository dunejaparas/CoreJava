package com.pd.core.patterns.behavioral.visitor.example.shoppingcart;

/**
 *
 * Notice that accept method takes Visitor argument, we can have some other
 * methods also specific for items but for simplicity I am not going into that
 * much detail and focusing on visitor pattern only.
 *
 */
public interface IItemElement {

    public int accept(IShoppingCartVisitor visitor);

}
