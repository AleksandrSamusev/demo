package MyExample1.demo.service;

import MyExample1.demo.dto.OrderDto;
import MyExample1.demo.dto.OrderShortDto;
import MyExample1.demo.exception.OrderNotFoundException;
import MyExample1.demo.mapper.OrderMapper;
import MyExample1.demo.mapper.UserMapper;
import MyExample1.demo.model.Order;
import MyExample1.demo.repository.OrderRepository;
import MyExample1.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OrderDto createOrder(OrderShortDto orderShortDto) {
        Order order = new Order();
        order.setUser(userRepository.getReferenceById(orderShortDto.getUserId()));
        order.setCreationDate(orderShortDto.getCreationDate());
        order.setDeliveryDate(orderShortDto.getDeliveryDate());
        return OrderMapper.toOrderDto(orderRepository.save(order));
    }

    @Override
    public Iterable<OrderDto> getAllOrders() {
        return OrderMapper.toOrderDtos(orderRepository.findAll());
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        validateOrderId(orderId);
        return OrderMapper.toOrderDto(orderRepository.getReferenceById(orderId));
    }

    @Override
    public OrderDto updateOrderById(Long orderId, OrderDto orderDto) {
        if (orderRepository.existsById(orderId)) {
            Order order = orderRepository.getReferenceById(orderId);
            if (orderDto.getCreationDate() != null) {
                order.setCreationDate(orderDto.getCreationDate());
            }
            if (orderDto.getDeliveryDate() != null) {
                order.setDeliveryDate(orderDto.getDeliveryDate());
            }
            if (orderDto.getUserDto() != null) {
                order.setUser(UserMapper.toUser(orderDto.getUserDto()));
            }
            if (orderDto.getLines() != null) {
                order.setLines(orderDto.getLines());
            }
            return OrderMapper.toOrderDto(orderRepository.save(order));
        }
        return OrderMapper.toOrderDto(orderRepository.save(OrderMapper.toOrder(orderDto)));
    }

    @Override
    public void deleteOrderById(Long orderId) {
        validateOrderId(orderId);
        orderRepository.deleteById(orderId);
    }

    private void validateOrderId(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            log.info("order with id = {} not found", orderId);
            throw new OrderNotFoundException("Order not found");
        }
    }
}
