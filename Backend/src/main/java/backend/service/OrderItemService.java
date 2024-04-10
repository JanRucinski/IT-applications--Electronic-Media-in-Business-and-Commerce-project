package backend.service;

import backend.model.OrderItem;

import java.util.List;

interface OrderItemService {
    OrderItem addOrderItem(OrderItem orderItem);
    OrderItem deleteOrderItem(long id);
    List<OrderItem> findAllOrderItems();
    OrderItem updateOrderItem(OrderItem orderItem);
    OrderItem findOrderItemById(long id);
}