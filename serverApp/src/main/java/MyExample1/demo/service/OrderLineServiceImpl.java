package MyExample1.demo.service;

import MyExample1.demo.dto.OrderLineDto;
import MyExample1.demo.exception.OrderLineNotFoundException;
import MyExample1.demo.mapper.OrderLineMapper;
import MyExample1.demo.mapper.OrderMapper;
import MyExample1.demo.model.OrderLine;
import MyExample1.demo.repository.OrderLineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderLineServiceImpl implements OrderLineService {
    private final OrderLineRepository orderLineRepository;

    public OrderLineServiceImpl(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public OrderLineDto createOrderLine(OrderLineDto orderLineDto) {
        return OrderLineMapper.toOrderLineDto(orderLineRepository.save(OrderLineMapper
                .toOrderLine(orderLineDto)));
    }

    @Override
    public Iterable<OrderLineDto> getAllOrderLines() {
        return OrderLineMapper.toOrderLineDtos(orderLineRepository.findAll());
    }

    @Override
    public OrderLineDto getOrderLineById(Long orderLineId) {
        validateOrderLineId(orderLineId);
        return OrderLineMapper.toOrderLineDto(orderLineRepository.getReferenceById(orderLineId));
    }

    @Override
    public void deleteOrderLineById(Long orderLineId) {
        validateOrderLineId(orderLineId);
        orderLineRepository.deleteById(orderLineId);
    }

    @Override
    public OrderLineDto updateOrderLineById(Long orderLineId, OrderLineDto orderLineDto) {
        if(orderLineRepository.existsById(orderLineId)) {
            OrderLine orderLine = new OrderLine();
            if(orderLineDto.getOrderDto()!=null) {
                orderLine.setOrder(OrderMapper.toOrder(orderLineDto.getOrderDto()));
            }
            if(orderLineDto.getProduct()!=null) {
                orderLine.setProduct(orderLineDto.getProduct());
            }
            if(orderLineDto.getQuantity()!=null) {
                orderLine.setQuantity(orderLineDto.getQuantity());
            }
            if(orderLineDto.getMeasureUnit()!=null) {
                orderLine.setMeasureUnit(orderLineDto.getMeasureUnit());
            }
            return OrderLineMapper.toOrderLineDto(orderLineRepository.save(orderLine));
        }
        return OrderLineMapper.toOrderLineDto(orderLineRepository.save(OrderLineMapper.toOrderLine(orderLineDto)));
    }

    private void validateOrderLineId(Long orderLineId) {
        if (!orderLineRepository.existsById(orderLineId)) {
            log.info("Order line with id = {} not found", orderLineId);
            throw new OrderLineNotFoundException("Order line not found");
        }
    }
}
