package backend.service;

import backend.model.Order;
import backend.model.Rental;
import backend.model.User;
import backend.repository.OrderRepository;
import backend.repository.RentalRepository;
import backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RentalRepository rentalRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RentalRepository rentalRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.rentalRepository = rentalRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public User addUser(User user) {
        user.setModifiedAt(OffsetDateTime.now());
        user.setCreatedAt(OffsetDateTime.now());
        if (user.getActive() == null) {
            user.setActive(true);
        }
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            List<Rental> rentals = rentalRepository.findRentalsByUserId(id);
            for (Rental rental : rentals) {
                rental.setUser(null);
                rentalRepository.save(rental);
            }
            List<Order> orders = orderRepository.findOrdersByUserId(id);
            for (Order order : orders) {
                order.setUser(null);
                orderRepository.save(order);
            }
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> ou = userRepository.findById(id);
        if (ou.isPresent()) {
            ou.get().setUsername(user.getUsername());
            ou.get().setPassword(user.getPassword());
            ou.get().setEmail(user.getEmail());
            ou.get().setFirstName(user.getFirstName());
            ou.get().setLastName(user.getLastName());
            ou.get().setPhone(user.getPhone());
            ou.get().setRole(user.getRole());
            if (user.getActive() != null) {
                ou.get().setActive(user.getActive());
            } else {
                ou.get().setActive(true);
            }
            ou.get().setModifiedAt(OffsetDateTime.now());
            return userRepository.save(ou.get());
        }
        return null;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findUserByUsernameOrEmail(String input) {
        return userRepository.findUserByUsernameOrEmail(input, input);
    }
}
