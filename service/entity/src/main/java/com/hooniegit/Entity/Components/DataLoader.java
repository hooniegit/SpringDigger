package com.hooniegit.Entity.Components;

import com.hooniegit.Entity.Coffee;
import com.hooniegit.Entity.Controllers.CoffeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {

    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    public void init() {
        this.coffeeRepository.saveAll(List.of(
                new Coffee("Cafe Latte"),
                new Coffee("Americano"),
                new Coffee("Cold Brew"),
                new Coffee("Hot Chocolate")
        ));
    }

}
