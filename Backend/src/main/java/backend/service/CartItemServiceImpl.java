package backend.service;

import backend.model.CartItem;
import backend.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem deleteCartItem(long id) {
        return null;
    }

    @Override
    public List<CartItem> findAllCartItems() {
        return null;
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem findCartItemById(long id) {
        return null;
    }
}
