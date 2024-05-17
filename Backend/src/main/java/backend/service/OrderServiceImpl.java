package backend.service;

import backend.model.Order;
import backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order orderDTO) {
        Order order = orderRepository.save(new Order(orderDTO.getUser(), orderDTO.getTotal()));
        orderDTO.setId(order.getId());
        orderDTO.setCreatedAt(order.getCreatedAt());
        orderDTO.setModifiedAt(order.getModifiedAt());
        return orderDTO;
    }

    @Override
    public Order deleteOrder(long id) {
        Optional<Order> oo = orderRepository.findById(id);
        if (oo.isPresent()) {
            orderRepository.deleteById(id);
            return createDTOFromEntity(oo.get());
        }
        return null;
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<Order> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            orderDTOs.add(createDTOFromEntity(order));
        }
        return orderDTOs;
    }

    @Override
    public Order updateOrder(Order orderDTO) {
        Optional<Order> oo = orderRepository.findById(orderDTO.getId());
        if (oo.isPresent()) {
            oo.get().setTotal(orderDTO.getTotal());
            oo.get().setModifiedAt(OffsetDateTime.now());
            orderRepository.save(oo.get());
            orderDTO = createDTOFromEntity(oo.get());
            return orderDTO;
        }
        return null;
    }

    @Override
    public Order findOrderById(long id) {
        Optional<Order> oo = orderRepository.findById(id);
        return oo.map(this::createDTOFromEntity).orElse(null);
    }

    public Order createDTOFromEntity(Order order) {
        Order orderDTO = new Order();
        orderDTO.setId(order.getId());
        orderDTO.setUser(order.getUser());
        orderDTO.setTotal(order.getTotal());
        orderDTO.setPayment(order.getPayment());
        orderDTO.setCreatedAt(order.getCreatedAt());
        orderDTO.setModifiedAt(order.getModifiedAt());
        return orderDTO;
    }
}
