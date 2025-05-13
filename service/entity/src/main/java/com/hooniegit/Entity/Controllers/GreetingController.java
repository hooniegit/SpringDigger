package com.hooniegit.Entity.Controllers;

import com.hooniegit.Entity.Configurations.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Value("${greeting.name: Mirage}")
    private String name;

    @Value("${greeting.coffee: ${greeting.name} is drinking Cafe Ganador}")
    private String coffee;

    @GetMapping
    public String getGreeting() {
        return this.name;
    }

    @GetMapping("/coffee")
    public String getCoffee() {
        return this.coffee;
    }

    private final Greeting greeting;

    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping("/config")
    public String getGreetingConfig() {
        return this.greeting.getName();
    }

    @GetMapping("/config/coffee")
    public String getCoffeeConfig() {
        return this.greeting.getCoffee();
    }

}
