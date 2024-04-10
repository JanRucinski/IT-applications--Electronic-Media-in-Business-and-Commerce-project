package backend.service;

import backend.model.Order;

import java.util.List;

interface OrderService {
    Order addOrder(Order order);
    Order deleteOrder(long id);
    List<Order> findAllOrders();
    Order updateOrder(Order order);
    Order findOrderById(long id);
}