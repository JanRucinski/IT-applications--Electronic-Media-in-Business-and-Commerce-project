package backend.service;

import backend.model.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem addCartItem(CartItem cartItem);
    CartItem deleteCartItem(long id);
    List<CartItem> findAllCartItems();
    CartItem updateCartItem(CartItem cartItem);
    CartItem findCartItemById(long id);
}