package backend.service;

import backend.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);
    Order deleteOrder(long id);
    List<Order> findAllOrders();
    Order updateOrder(Order order);
    Order findOrderById(long id);
}