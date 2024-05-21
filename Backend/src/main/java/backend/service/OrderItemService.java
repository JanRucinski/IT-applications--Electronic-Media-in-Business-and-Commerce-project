package backend.service;

import backend.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem addOrderItem(OrderItem orderItem);

    boolean deleteOrderItem(Long id);

    List<OrderItem> findAllOrderItems();

    OrderItem updateOrderItem(Long id, OrderItem orderItem);

    OrderItem findOrderItemById(Long id);
}