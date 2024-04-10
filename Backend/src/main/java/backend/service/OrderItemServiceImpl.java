package backend.service;

import backend.model.OrderItem;
import backend.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem addOrderItem(OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItem deleteOrderItem(long id) {
        return null;
    }

    @Override
    public List<OrderItem> findAllOrderItems() {
        return null;
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItem findOrderItemById(long id) {
        return null;
    }
}
