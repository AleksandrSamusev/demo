package MyExample1.demo.repository;

import MyExample1.demo.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {

}
