package MyExample1.demo.mapper;

import MyExample1.demo.dto.OrderLineDto;
import MyExample1.demo.model.OrderLine;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderLineMapper {
    public static OrderLine toOrderLine(OrderLineDto orderLineDto) {
        OrderLine orderLine = new OrderLine();
        orderLine.setOrderLine_id(orderLineDto.getOrderLine_id());
        orderLine.setOrder(OrderMapper.toOrder(orderLineDto.getOrderDto()));
        orderLine.setProduct(ProductMapper.toProduct(orderLineDto.getProductDto()));
        orderLine.setQuantity(orderLineDto.getQuantity());
        orderLine.setMeasureUnit(orderLineDto.getMeasureUnit());
        return orderLine;
    }

    public static OrderLineDto toOrderLineDto(OrderLine orderLine) {
        OrderLineDto orderLineDto = new OrderLineDto();
        orderLineDto.setOrderLine_id(orderLine.getOrderLine_id());
        orderLineDto.setOrderDto(OrderMapper.toOrderDto(orderLine.getOrder()));
        orderLineDto.setProductDto(ProductMapper.toProductDto(orderLine.getProduct()));
        orderLineDto.setQuantity(orderLine.getQuantity());
        orderLineDto.setMeasureUnit(orderLine.getMeasureUnit());
        return orderLineDto;
    }

    public static List<OrderLine> toOrderLines(List<OrderLineDto> orderLineDtos) {
        List<OrderLine> orderLines = new ArrayList<>();
        for (OrderLineDto orderLineDto : orderLineDtos) {
            orderLines.add(toOrderLine(orderLineDto));
        }
        return orderLines;
    }

    public static List<OrderLineDto> toOrderLineDtos(List<OrderLine> orderLines) {
        List<OrderLineDto> orderLineDtos = new ArrayList<>();
        for (OrderLine orderLine : orderLines) {
            orderLineDtos.add(toOrderLineDto(orderLine));
        }
        return orderLineDtos;
    }
}
