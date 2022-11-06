package MyExample1.demo.repository;

import MyExample1.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.user.userId = ?1")
    List<Order> getOrdersByUserId(Long userId);
}
