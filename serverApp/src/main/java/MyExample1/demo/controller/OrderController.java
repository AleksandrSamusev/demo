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
    public OrderDto createOrder(@RequestBody OrderShortDto orderShortDto, @PathVariable Long userId) {
        return orderService.createOrder(orderShortDto, userId);
    }
}
