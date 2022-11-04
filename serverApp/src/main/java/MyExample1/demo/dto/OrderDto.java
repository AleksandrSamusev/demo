package MyExample1.demo.dto;

import MyExample1.demo.model.OrderLine;
import MyExample1.demo.model.User;
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
    private User user;
    private LocalDateTime deliveryDate;
    private List<OrderLine> lines;

}
