package MyExample1.demo;

import MyExample1.demo.model.Coffee;
import MyExample1.demo.repository.CoffeeRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoader {
    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void LoadData() {
        coffeeRepository.saveAll(List.of(
                new Coffee("first coffee"),
                new Coffee("second coffee"),
                new Coffee("bla-bla coffee"),
                new Coffee("forth coffee")
        ));
    }
}
