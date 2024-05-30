package backend.service;

import backend.model.Order;
import backend.model.OrderItem;
import backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order addOrder(Order order) {
        order.setModifiedAt(OffsetDateTime.now());
        order.setCreatedAt(OffsetDateTime.now());
        order.getPayment().setModifiedAt(OffsetDateTime.now());
        order.getPayment().setCreatedAt(OffsetDateTime.now());
        for (OrderItem orderItem : order.getOrderItems()) {
            orderItem.setModifiedAt(OffsetDateTime.now());
            orderItem.setCreatedAt(OffsetDateTime.now());
        }
        return orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Optional<Order> oo = orderRepository.findById(id);
        if (oo.isPresent()) {
            oo.get().setStatus(order.getStatus());
            oo.get().getPayment().setStatus(order.getPayment().getStatus());
            oo.get().getPayment().setModifiedAt(OffsetDateTime.now());
            oo.get().setModifiedAt(OffsetDateTime.now());
            for (OrderItem orderItem : oo.get().getOrderItems()) {
                orderItem.setModifiedAt(OffsetDateTime.now());
            }
            return orderRepository.save(oo.get());
        }
        return null;
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
