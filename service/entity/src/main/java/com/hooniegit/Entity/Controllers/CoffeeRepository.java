package com.hooniegit.Entity.Controllers;

import com.hooniegit.Entity.Coffee;
import org.springframework.data.repository.CrudRepository;

/**
 * 저장소 사용 :: Spring Data Repository 인터페이스를 상속할 인터페이스 정의 필요
 */
public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
