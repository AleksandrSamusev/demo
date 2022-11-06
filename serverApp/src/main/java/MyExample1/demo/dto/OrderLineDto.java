package MyExample1.demo.dto;

import MyExample1.demo.model.MeasureUnitType;
import MyExample1.demo.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDto {
    private Long orderLine_id;
    private OrderDto orderDto;
    private Product product;
    private Double quantity;
    private MeasureUnitType measureUnit;
}
