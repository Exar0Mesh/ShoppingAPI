package org.yearup.data;

import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);

    ShoppingCart create( ShoppingCart shoppingCart);

    ShoppingCart updateCart(ShoppingCart shoppingCart);

    ShoppingCart deleteItem(ShoppingCart shoppingCart);

    // add additional method signatures here
}
