package MyExample1.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
@Data
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderLine_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Enumerated(EnumType.STRING)
    private MeasureUnitType measureUnit;
}
