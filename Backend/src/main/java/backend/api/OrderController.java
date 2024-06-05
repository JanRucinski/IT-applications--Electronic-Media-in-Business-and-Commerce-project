package backend.api;

import backend.model.*;
import backend.service.ItemService;
import backend.service.OrderService;
import backend.service.PaymentService;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
public class OrderController {
    private final OrderService os;
    private final ItemService is;
    private final UserService us;
    private final PaymentService ps;

    @Autowired
    public OrderController(OrderService os, ItemService is, UserService us, PaymentService ps) {
        this.os = os;
        this.is = is;
        this.us = us;
        this.ps = ps;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO orderDTO) {
        if (orderDTO == null || orderDTO.getUserId() == null || orderDTO.getPayment() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
            if (orderItemDTO == null || orderItemDTO.getItemId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }

        User user = us.findUserById(orderDTO.getUserId());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Order order = new Order(orderDTO);
        order.setUser(user);
        order.setPayment(new Payment(orderDTO.getPayment()));

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
            Item item = is.findItemById(orderItemDTO.getItemId());
            if (item == null || item.getQuantity() < orderItemDTO.getQuantity()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            OrderItem orderItem = new OrderItem(orderItemDTO);
            orderItem.setOrder(order);
            orderItem.setItem(item);
            orderItem.setPrize(item.getPrice());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);

        order.setTotal(order.getOrderItems().stream().map(item -> item.getPrize().multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add));
        order.getPayment().setAmount(order.getTotal());

        order = os.addOrder(order);
        for (OrderItem orderItem : order.getOrderItems()) {
            is.updateItemQuantity(orderItem, true);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new OrderDTO(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
        Order order = os.findOrderById(id);
        if (order != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new OrderDTO(order));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders() {
        List<Order> orders = os.findAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(orders.stream().map(OrderDTO::new).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        if (orderDTO == null || orderDTO.getPayment() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Order order = new Order(orderDTO);
        order.setPayment(new Payment(orderDTO.getPayment()));
        order = os.updateOrder(id, order);
        if (order != null) {
            if (orderDTO.getStatus() == Order.OrderStatus.CANCELLED) {
                for (OrderItem orderItem : order.getOrderItems()) {
                    is.updateItemQuantity(orderItem, false);
                }
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(new OrderDTO(order));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        boolean deleted = os.deleteOrder(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
