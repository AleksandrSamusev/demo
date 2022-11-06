package MyExample1.demo.controller;

import MyExample1.demo.dto.OrderDto;
import MyExample1.demo.dto.OrderShortDto;
import MyExample1.demo.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/orders")
public class OrderController {
    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{userId}")
    public OrderDto createOrder(@RequestBody OrderShortDto orderShortDto) {
        return orderService.createOrder(orderShortDto);
    }

    @GetMapping
    public Iterable<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public OrderDto getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PatchMapping("/{orderId}")
    public OrderDto updateOrderById(@PathVariable Long orderId, @RequestBody OrderDto orderDto) {
        return orderService.updateOrderById(orderId, orderDto);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrderById(@PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
    }


}
