package com.hooniegit.Sample;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter @AllArgsConstructor
public class Coffee {

    private final String id;

    @Setter
    private String name;

    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }

}
