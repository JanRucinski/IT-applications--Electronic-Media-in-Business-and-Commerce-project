package backend;

import backend.model.Category;
import backend.service.CategoryService;
import backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BikeShopApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @Test
    void contextLoads() {
        Category category = new Category();
        category.setSuperCategory(Category.SuperCategory.BIKES);
        category.setName("test");
        categoryService.addCategory(category);
//        Category category = categoryService.findCategoryById(1L);
//        System.out.println(category);
//        User user1 = new User("testlogin", "test", "testemail", "test", "test", 111111111);
//        user1.setPlainPassword("test");
//        User user2 = new User("test2", "test", "test2", "test", "test", 111111111);
//        user2.setPlainPassword("test");
//        User user3 = new User("test3", "test", "test3", "test", "test", 111111111);
//        user3.setPlainPassword("test");
//        userService.addUser(user1);
//        userService.addUser(user2);
//        userService.addUser(user3);
//        List<User> users = userService.findAllUsers();
//        User user = userService.findUserByUsernameOrEmail("test2");
//        boolean check = user.verifyPassword("test");
//        user = userService.findUserByUsernameOrEmail("testlogin");
//        check = user.verifyPassword("test");
//        user = userService.findUserByUsernameOrEmail("test3");
//        check = user.verifyPassword("test");
//        user = userService.findUserByUsernameOrEmail("testemail");
//        check = user.verifyPassword("test");
//
//        User user1 = new User("test", "test", "test", "test", "test", 111111111);
//        user1.setPlainPassword("test");
//        User user2 = new User("test2", "test", "test2", "test", "test", 111111111);
//        user2.setPlainPassword("test");
//        userService.addUser(user1);
//        userService.addUser(user2);
//        Cart cart1 = new Cart(BigDecimal.valueOf(5.5), user1);
//        Cart cart2 = new Cart(BigDecimal.valueOf(6.5), user2);
//        cartService.addCart(cart1);
//        cartService.addCart(cart2);
//        cart1.setTotal(BigDecimal.valueOf(10.5));
//        cartService.updateCart(cart1);
//        List<Cart> carts = cartService.findAllCarts();
//        Cart cart = cartService.findCartById(1);
//        cart = cartService.findCartById(2);
//        cartService.deleteCart(1L);
//        cartService.deleteCart(2L);
//        User user3 = new User("test3", "test", "test3", "test", "test", 111111111);
//        user3.setPlainPassword("test");
//        userService.addUser(user3);
//        Cart cart3 = new Cart(BigDecimal.valueOf(7.5), user3);
//        cartService.addCart(cart3);
//        List<User> users = userService.findAllUsers();
//        carts = cartService.findAllCarts();
//        userService.deleteUser(3);
//        users = userService.findAllUsers();
//        carts = cartService.findAllCarts();
//        carts = cartService.findAllCarts();
//        cart = cartService.findCartById(1);
//        User user = userService.findUserById(3);
//        List<User> users = userService.findAllUsers();
//        user.setUsername("test");
//        userService.updateUser(user);
//        user.setUsername("test3");
//        user.setEmail("test");
//        userService.updateUser(user);
//
//        User user1 = new User("test", "test", "test", "test", "test", 111111111);
//        user1.setPlainPassword("test");
//        userService.addUser(user1);
//        Cart cart1 = new Cart(BigDecimal.valueOf(5.5), user1);
//        cartService.addCart(cart1);
//        user1.setCart(cart1);
//        userService.updateUser(user1);
//        List<User> users = userService.findAllUsers();
//        List<Cart> carts = cartService.findAllCarts();
    }
}
