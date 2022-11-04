package MyExample1.demo.dto;

import MyExample1.demo.model.MeasureUnitType;
import MyExample1.demo.model.Order;
import MyExample1.demo.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDto {
    private Long orderLine_id;
    private Order order;
    private Product product;
    private Double quantity;
    private MeasureUnitType measureUnit;
}
