package backend.service;

import backend.model.Order;
import backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return null;
    }

    @Override
    public Order deleteOrder(long id) {
        return null;
    }

    @Override
    public List<Order> findAllOrders() {
        return null;
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }

    @Override
    public Order findOrderById(long id) {
        return null;
    }
}
