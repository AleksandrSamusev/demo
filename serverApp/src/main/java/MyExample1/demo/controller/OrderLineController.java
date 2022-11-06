package MyExample1.demo.controller;

import MyExample1.demo.dto.OrderLineDto;
import MyExample1.demo.service.OrderLineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/orderLines")
public class OrderLineController {
    private final OrderLineService orderLineService;

    @Autowired
    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @PostMapping("/order/{orderId}/product/{productId}")
    public OrderLineDto createOrderLine(@RequestBody OrderLineDto orderLineDto,
                                        @PathVariable Long orderId,
                                        @PathVariable Long productId) {
        return orderLineService.createOrderLine(orderLineDto, orderId, productId);
    }

    @GetMapping
    public Iterable<OrderLineDto> getAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }

    @GetMapping("/{orderLineId}")
    public OrderLineDto getOrderLineById(@PathVariable Long orderLineId) {
        return orderLineService.getOrderLineById(orderLineId);
    }

    @DeleteMapping("/{orderLineId}")
    public void deleteOrderLineById(@PathVariable Long orderLineId) {
        orderLineService.deleteOrderLineById(orderLineId);
    }

    @PatchMapping("/{orderLineId}")
    public OrderLineDto updateOrderLineById(@PathVariable Long orderLineId, @RequestBody OrderLineDto orderLineDto) {
        return orderLineService.updateOrderLineById(orderLineId, orderLineDto);
    }
}
