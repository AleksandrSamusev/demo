package MyExample1.demo.service;

import MyExample1.demo.dto.OrderLineDto;

public interface OrderLineService {
    OrderLineDto createOrderLine(OrderLineDto orderLineDto);

    Iterable<OrderLineDto> getAllOrderLines();

    OrderLineDto getOrderLineById(Long orderLineId);

    void deleteOrderLineById(Long orderLineId);

    OrderLineDto updateOrderLineById(Long orderLineId, OrderLineDto orderLineDto);

}
