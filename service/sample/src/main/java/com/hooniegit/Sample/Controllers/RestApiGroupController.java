package com.hooniegit.Sample.Controllers;

import com.hooniegit.Sample.Coffee;
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

    private List<Coffee> coffees = new ArrayList<>();

    public RestApiGroupController() {
        this.coffees.addAll(List.of(
                new Coffee("Americano"),
                new Coffee("Latte"),
                new Coffee("Cappuccino"),
                new Coffee("Espresso")
        ));
    }

    /**
     * 예제 GET
     *
     * @return
     */
    @GetMapping
    Iterable<Coffee> getCoffeesSimple() {
        return coffees;
    }

    /**
     * 예제 GET
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(String id) {
        for (Coffee coffee : coffees) {
            if (coffee.getId().equals(id)) {
                return Optional.of(coffee);
            }
        }

        return Optional.empty();
    }

    /**
     * 예제 POST
     *
     * @param coffee
     * @return
     */
    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {
        // Coffee 객체를 List에 추가
        this.coffees.add(coffee);
        return coffee;
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
        int index = -1;

        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                index = coffees.indexOf(c);
                this.coffees.set(index, coffee);
                break;
            }
        }

        return (index == -1) ?
            // CREATED (201)
            new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
            // OK (200
            new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    /**
     * 예제 DELETE
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        this.coffees.removeIf(c -> c.getId().equals(id));
    }

}
