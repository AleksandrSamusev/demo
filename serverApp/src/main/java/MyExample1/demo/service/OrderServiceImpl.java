package MyExample1.demo.service;

import MyExample1.demo.dto.OrderDto;
import MyExample1.demo.dto.OrderShortDto;
import MyExample1.demo.mapper.OrderMapper;
import MyExample1.demo.model.Order;
import MyExample1.demo.repository.OrderRepository;
import MyExample1.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OrderDto createOrder(OrderShortDto orderShortDto, Long userId) {
        Order order = new Order();
        order.setUser(userRepository.getReferenceById(userId));
        order.setCreationDate(orderShortDto.getCreationDate());
        order.setDeliveryDate(orderShortDto.getDeliveryDate());
        return OrderMapper.toOrderDto(orderRepository.save(order));
    }
}
