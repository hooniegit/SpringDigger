package com.hooniegit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {

    @Id
    private String id;
    private String name;

    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }

}
