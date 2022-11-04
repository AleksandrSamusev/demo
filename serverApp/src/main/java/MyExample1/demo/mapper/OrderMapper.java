package MyExample1.demo.mapper;

import MyExample1.demo.dto.OrderDto;
import MyExample1.demo.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    public static Order toOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrder_id(orderDto.getOrder_id());
        order.setUser(orderDto.getUser());
        order.setLines(orderDto.getLines());
        order.setCreationDate(orderDto.getCreationDate());
        order.setDeliveryDate(orderDto.getDeliveryDate());
        return order;
    }

    public static OrderDto toOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrder_id(order.getOrder_id());
        orderDto.setUser(order.getUser());
        orderDto.setLines(order.getLines());
        orderDto.setCreationDate(order.getCreationDate());
        orderDto.setDeliveryDate(order.getDeliveryDate());
        return orderDto;
    }

    public static List<Order> toOrders(List<OrderDto> orderDtos) {
        List<Order> orders = new ArrayList<>();
        for (OrderDto orderDto : orderDtos) {
            orders.add(toOrder(orderDto));
        }
        return orders;
    }

    public static List<OrderDto> toOrderDtos(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(toOrderDto(order));
        }
        return orderDtos;
    }
}
