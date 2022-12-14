package MyExample1.demo.dto;

import MyExample1.demo.model.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long order_id;
    private LocalDateTime creationDate = LocalDateTime.now();
    private UserDto userDto;
    private LocalDateTime deliveryDate;
    private List<OrderLine> lines;

}
