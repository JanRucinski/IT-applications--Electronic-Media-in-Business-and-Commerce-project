package backend.service;

import backend.model.Cart;
import backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addCart(Cart cart) {
        return null;
    }

    @Override
    public Cart deleteCart(long id) {
        return null;
    }

    @Override
    public List<Cart> findAllCarts() {
        return null;
    }

    @Override
    public Cart updateCart(Cart cart) {
        return null;
    }

    @Override
    public Cart findCartById(long id) {
        return null;
    }
}
