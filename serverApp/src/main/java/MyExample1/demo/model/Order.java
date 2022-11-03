package MyExample1.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "delivery_date")
    @Future
    private LocalDateTime deliveryDate;


}
