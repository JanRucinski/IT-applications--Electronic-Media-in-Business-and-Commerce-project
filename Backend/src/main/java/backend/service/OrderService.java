package backend.service;

import backend.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);

    boolean deleteOrder(Long id);

    List<Order> findAllOrders();

    Order updateOrder(Long id, Order order);

    Order findOrderById(Long id);

    List<Order> findOrdersByUserId(Long userId);
}