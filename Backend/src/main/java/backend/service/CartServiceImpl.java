package backend.service;

import backend.model.Cart;
import backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addCart(Cart cartDTO) {
        Cart cart = cartRepository.save(new Cart(cartDTO.getTotal(), cartDTO.getUser()));
        cartDTO.setId(cart.getId());
        cartDTO.setCreatedAt(cart.getCreatedAt());
        cartDTO.setModifiedAt(cart.getModifiedAt());
        return cartDTO;
    }

    @Override
    public Cart deleteCart(long id) {
        Optional<Cart> oc = cartRepository.findById(id);
        if (oc.isPresent()) {
            cartRepository.deleteById(id);
            return createDTOFromEntity(oc.get());
        }
        return null;
    }

    @Override
    public List<Cart> findAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        List<Cart> cartDTOs = new ArrayList<>();
        for (Cart cart : carts) {
            cartDTOs.add(createDTOFromEntity(cart));
        }
        return cartDTOs;
    }

    @Override
    public Cart updateCart(Cart cartDTO) {
        Optional<Cart> oc = cartRepository.findById(cartDTO.getId());
        if (oc.isPresent()) {
            oc.get().setTotal(cartDTO.getTotal());
            oc.get().setModifiedAt(OffsetDateTime.now());
            cartRepository.save(oc.get());
            cartDTO.setModifiedAt(oc.get().getModifiedAt());
            return cartDTO;
        }
        return null;
    }

    @Override
    public Cart findCartById(long id) {
        Optional<Cart> oc = cartRepository.findById(id);
        return oc.map(this::createDTOFromEntity).orElse(null);
    }

    public Cart createDTOFromEntity(Cart cart) {
        Cart cartDTO = new Cart();
        cartDTO.setId(cart.getId());
        cartDTO.setTotal(cart.getTotal());
        cartDTO.setUser(cart.getUser());
        cartDTO.setCreatedAt(cart.getCreatedAt());
        cartDTO.setModifiedAt(cart.getModifiedAt());
        return cartDTO;
    }
}
