package com.hooniegit.Redis.Components;

import com.hooniegit.Redis.Datas.Aircraft;
import com.hooniegit.Redis.Repository.AircraftRepository;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
public class PlaneFinderPoller {

    private WebClient client = WebClient.create("http://localhost:7634");
    private final RedisConnectionFactory redisConnectionFactory;
    private final AircraftRepository aircraftRepository;

    public PlaneFinderPoller(RedisConnectionFactory redisConnectionFactory, AircraftRepository aircraftRepository) {
        this.redisConnectionFactory = redisConnectionFactory;
        this.aircraftRepository = aircraftRepository;
    }

    @Scheduled(fixedRate = 1000)
    private void pollPlanes() {
        redisConnectionFactory.getConnection().serverCommands().flushDb();

        client.get()
                .uri("/aircraft")
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(plane -> !plane.getReg().isEmpty())
                .toStream()
                .forEach(this.aircraftRepository::save);

        aircraftRepository.findAll().forEach(System.out::println);
    }

}
