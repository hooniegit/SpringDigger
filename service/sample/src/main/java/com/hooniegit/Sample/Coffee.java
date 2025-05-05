package com.hooniegit.Sample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class Coffee {

    // 재선언 불가능 final 필드 :: 변경자 없음
    private final String id;

    // 재선언 가능 필드
    @Setter
    private String name;

    // 생성자 :: id 자동 생성
    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }

}
