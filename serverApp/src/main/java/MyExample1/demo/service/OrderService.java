package MyExample1.demo.service;

import MyExample1.demo.dto.OrderDto;
import MyExample1.demo.dto.OrderShortDto;

public interface OrderService {

    OrderDto createOrder(OrderShortDto orderShortDto);

    Iterable<OrderDto> getAllOrders();

    OrderDto getOrderById(Long orderId);

    OrderDto updateOrderById(Long orderId, OrderDto orderDto);

    void deleteOrderById(Long orderId);

}
