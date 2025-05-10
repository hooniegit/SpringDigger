package com.hooniegit.Entity.Controllers;

import com.hooniegit.Entity.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * API 컨트롤러 작업 절차
 *
 * 1. 어노테이션 기반으로 메서드 생성
 * 2. 리팩토링을 통한 코드 간소화
 * 3. (필요한 경우) HTTP 상태 코드 반환
 */

@RestController
@RequestMapping("/coffees")
public class RestApiGroupController {

    private final CoffeeRepository coffeeRepository;

    public RestApiGroupController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    /**
     * 예제 GET
     *
     * @return
     */
    @GetMapping
    Iterable<Coffee> getCoffeesSimple() {
        // return coffees;
        return this.coffeeRepository.findAll();
    }

    /**
     * 예제 GET
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        // for (Coffee coffee : coffees) {
        //     if (coffee.getId().equals(id)) {
        //         return Optional.of(coffee);
        //     }
        // }
        // return Optional.empty();
        return this.coffeeRepository.findById(id);
    }

    /**
     * 예제 POST
     *
     * @param coffee
     * @return
     */
    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {
        // this.coffees.add(coffee);
        // return coffee;
        return this.coffeeRepository.save(coffee);
    }

    /**
     * 예제 PUT
     * - ResponseEntity :: HTTP 상태 코드를 포함해 반환
     *
     * @param id
     * @param coffee
     * @return
     */
    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        // int index = -1;
        // for (Coffee c : coffees) {
        //     if (c.getId().equals(id)) {
        //         index = coffees.indexOf(c);
        //         this.coffees.set(index, coffee);
        //        break;
        //     }
        // }
        // return (index == -1) ?
        //     new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
        //     new ResponseEntity<>(coffee, HttpStatus.OK);
        return (this.coffeeRepository.existsById(id)) ?
                new ResponseEntity<>(coffee, HttpStatus.OK) :
                new ResponseEntity<>(this.coffeeRepository.save(coffee), HttpStatus.CREATED);
    }

    /**
     * 예제 DELETE
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        // this.coffees.removeIf(c -> c.getId().equals(id));
        this.coffeeRepository.deleteById(id);
    }

}
