package com.hooniegit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * 영속 가능 엔티티
 * - 자바 객체의 분류
 * - RDB 테이블과 매핑되어 JPA나 Hibernate 같은 ORM 프레임워크에 의해 영속성 관리가 가능
 * - 식별자 (@Id) 가 반드시 필요
 */
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {

    @Id
    private String id;
    private String name;

    /**
     * AllArgsConstructor 호출
     * @param name
     */
    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }

}
