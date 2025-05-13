package com.hooniegit.Sample.Controllers;

import com.hooniegit.Sample.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class RestApiGroupController {

    private List<Coffee> coffees = new ArrayList<>();

    public RestApiGroupController() {
        this.coffees.addAll(List.of(
                new Coffee("Americano"),
                new Coffee("Latte"),
                new Coffee("Cappuccino"),
                new Coffee("Espresso")
        ));
    }

    @GetMapping
    Iterable<Coffee> getCoffeesSimple() {
        return coffees;
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(String id) {
        for (Coffee coffee : coffees) {
            if (coffee.getId().equals(id)) {
                return Optional.of(coffee);
            }
        }

        return Optional.empty();
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {
        this.coffees.add(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int index = -1;

        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                index = coffees.indexOf(c);
                this.coffees.set(index, coffee);
                break;
            }
        }

        return (index == -1) ?
            new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
            new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        this.coffees.removeIf(c -> c.getId().equals(id));
    }

}
