package com.hooniegit.Sample.Controllers;

import com.hooniegit.Sample.Coffee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @RestController = @Controller + @ResponseBody
 * @RequestMapping :: Class 레벨에서 URL 매핑
 */
@RestController
@RequestMapping("/group")
public class RestApiFinalController {

    private List<Coffee> coffees = new ArrayList<>();

    public RestApiFinalController() {
        this.coffees.addAll(List.of(
                new Coffee("Americano"),
                new Coffee("Latte"),
                new Coffee("Cappuccino"),
                new Coffee("Espresso")
        ));
    }

    /**
     * 예제 GET
     * @return
     */
    @GetMapping("/coffees")
    Iterable<Coffee> getCoffeesSimple() {
        return coffees;
    }

    /**
     * 예제 GET
     * - Optional :: null을 허용하지 않는 Wrapper Class
     *
     * @param id
     * @return
     */
    @GetMapping("/coffees/{id}")
    Optional<Coffee> getCoffeeById(String id) {
        // 입력 id 의 객체가 존재하면 반환
        for (Coffee coffee : coffees) {
            if (coffee.getId().equals(id)) {
                return Optional.of(coffee);
            }
        }

        // 입력 id 의 객체가 존재하지 않으면 null 반환
        return Optional.empty();
    }

    /**
     * 예제 POST
     * - @RequestBody :: HTTP 요청 본문에서 Coffee 데이터를 Coffee 객체로 자동 Marshalling
     *
     * @param coffee
     * @return
     */
    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee) {
        // Coffee 객체를 List에 추가
        this.coffees.add(coffee);
        return coffee;
    }

    /**
     * 예제 PUT :: 식별자로 Coffee 객체를 찾아서 있으면 Update, 없으면 Create
     * - @PathVariable :: URL 경로에서 Coffee 객체의 id를 추출
     *
     * @param id
     * @param coffee
     * @return
     */
    @PutMapping("/coffees/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int index = -1;

        // Coffee 객체가 존재하면 List에서 Coffee 객체를 찾아서 Update
        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                index = coffees.indexOf(c);
                this.coffees.set(index, coffee);
                break;
            }
        }

        // Coffee 객체가 존재하지 않으면 새로 생성
        // == postCoffee() 메서드를 호출해서 사용 -> API 호출이 정답일지, 메서드 분리 후 직접 호출이 정답일지 고민 필요
        return (index != -1) ? postCoffee(coffee) : coffee;
    }

    /**
     * 예제 DELETE
     * - removeIf() :: Lambda 표현식을 사용해 true condition 경우에 해당 객체를 리스트에서 삭제
     *
     * @param id
     */
    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
        this.coffees.removeIf(c -> c.getId().equals(id));
    }

}
