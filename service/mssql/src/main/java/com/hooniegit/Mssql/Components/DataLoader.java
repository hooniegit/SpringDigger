package com.hooniegit.Mssql.Components;

import com.hooniegit.Mssql.Datas.Aircraft;
import com.hooniegit.Mssql.Repository.AircraftRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader {

    private final AircraftRepository aircraftRepository;

    @PostConstruct
    private void loadData() {
        this.aircraftRepository.deleteAll();

        this.aircraftRepository.save(
                new Aircraft() // Add Properties Here
        );
    }

}
