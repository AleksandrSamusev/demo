package MyExample1.demo.repository;

import MyExample1.demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("select a from Address a where a.user.userId = ?1")
    List<Address> getAddressesByUserId(Long userId);


}
