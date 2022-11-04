package MyExample1.demo.dto;

import MyExample1.demo.model.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    private List<OrderLine> orderLines;
    private String name;
    private String description;
    private BigDecimal price;
}
