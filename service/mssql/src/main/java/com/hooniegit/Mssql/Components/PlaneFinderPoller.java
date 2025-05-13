package com.hooniegit.Mssql.Components;

import com.hooniegit.Mssql.Datas.Aircraft;
import com.hooniegit.Mssql.Repository.AircraftRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
@RequiredArgsConstructor
public class PlaneFinderPoller {

    @NonNull
    private final AircraftRepository aircraftRepository;

    private final WebClient client = WebClient.create("http://localhost:7634");

    @Scheduled(fixedRate = 1000)
    private void pollPlanes() {
        this.aircraftRepository.deleteAll();

        this.client.get()
                .uri("/aircraft")
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(plane -> !plane.getReg().isEmpty())
                .toStream()
                .forEach(this.aircraftRepository::save);

        aircraftRepository.findAll().forEach(System.out::println);
    }

}
