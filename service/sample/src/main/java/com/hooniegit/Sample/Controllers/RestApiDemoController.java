package com.hooniegit.Sample.Controllers;

import com.hooniegit.Sample.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestApiDemoController {

    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController() {
        this.coffees.addAll(List.of(
                new Coffee("Americano"),
                new Coffee("Latte"),
                new Coffee("Cappuccino"),
                new Coffee("Espresso")
        ));
    }

    @RequestMapping(value = "/default/coffees", method = RequestMethod.GET)
    Iterable<Coffee> getCoffeesDefault() {
        return coffees;
    }

    @GetMapping("/simple/coffees")
    Iterable<Coffee> getCoffeesSimple() {
        return coffees;
    }

}
