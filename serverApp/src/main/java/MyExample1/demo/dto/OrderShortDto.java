package MyExample1.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderShortDto {
    private Long order_id;
    private LocalDateTime creationDate = LocalDateTime.now();
    private Long UserId;
    private LocalDateTime deliveryDate;

}

