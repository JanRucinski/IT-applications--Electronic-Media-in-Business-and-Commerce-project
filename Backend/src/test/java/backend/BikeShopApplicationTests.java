package backend;

import backend.model.Cart;
import backend.model.User;
import backend.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class BikeShopApplicationTests {
    @Autowired
    private CartService cartService;

    @Test
    void contextLoads() {
        Cart cart1 = new Cart(BigDecimal.valueOf(5.5), new User());
        Cart cart2 = new Cart(BigDecimal.valueOf(6.5), new User());
        cartService.addCart(cart1);
        cartService.addCart(cart2);
    }

}
