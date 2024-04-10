package backend.service;

import backend.model.Cart;

import java.util.List;

interface CartService {
    Cart addCart(Cart cart);
    Cart deleteCart(long id);
    List<Cart> findAllCarts();
    Cart updateCart(Cart cart);
    Cart findCartById(long id);
}