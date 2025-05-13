package com.hooniegit.Entity.Controllers;

import com.hooniegit.Entity.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
