package backend.service;

import backend.model.Order;
import backend.model.OrderItem;
import backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
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
            oo.get().setTotal(order.getTotal());
            oo.get().setPayment(order.getPayment());
            oo.get().setModifiedAt(OffsetDateTime.now());
            for (OrderItem orderItem : oo.get().getOrderItems()) {
                for (OrderItem changedOrderItem : order.getOrderItems()) {
                    if (Objects.equals(orderItem.getId(), changedOrderItem.getId())) {
                        orderItem.setQuantity(changedOrderItem.getQuantity());
                    }
                }
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
