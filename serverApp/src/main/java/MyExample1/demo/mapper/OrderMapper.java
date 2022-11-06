package MyExample1.demo.mapper;

import MyExample1.demo.dto.OrderDto;
import MyExample1.demo.dto.OrderShortDto;
import MyExample1.demo.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    public static Order toOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrder_id(orderDto.getOrder_id());
        order.setUser(UserMapper.toUser(orderDto.getUserDto()));
        order.setLines(orderDto.getLines());
        order.setCreationDate(orderDto.getCreationDate());
        order.setDeliveryDate(orderDto.getDeliveryDate());
        return order;
    }

    public static OrderDto toOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrder_id(order.getOrder_id());
        orderDto.setUserDto(UserMapper.toUserDto(order.getUser()));
        orderDto.setLines(order.getLines());
        orderDto.setCreationDate(order.getCreationDate());
        orderDto.setDeliveryDate(order.getDeliveryDate());
        return orderDto;
    }

    public static OrderShortDto toOrderShortDto(Order order) {
        OrderShortDto orderShortDto = new OrderShortDto();
        orderShortDto.setUserId(order.getUser().getUserId());
        orderShortDto.setOrder_id(order.getOrder_id());
        orderShortDto.setCreationDate(order.getCreationDate());
        orderShortDto.setDeliveryDate(order.getDeliveryDate());
        return orderShortDto;
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
