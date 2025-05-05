package com.hooniegit.Sample.Controllers;

import com.hooniegit.Sample.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @RestController = @Controller + @ResponseBody
 */
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

    /**
     * 예제 GET
     * - Spring Web 패키지에 포함된 Jackson 라이브러리 :: 객체를 JSON 또는 다른 포맷으로 Marchalling / Unmarchalling
     * - Iterable 인터페이스 :: Java Collection Framework 최상위 인터페이스
     * @return
     */
    @RequestMapping(value = "/default/coffees", method = RequestMethod.GET)
    Iterable<Coffee> getCoffeesDefault() {
        return coffees;
    }

    /**
     * 예제 GET
     * @return
     */
    @GetMapping("/simple/coffees")
    Iterable<Coffee> getCoffeesSimple() {
        return coffees;
    }

}
