package com.hooniegit.Redis.Components;

import com.hooniegit.Redis.Datas.Aircraft;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
public class PlaneFinderPoller {

    // REST API Client 생성
    private WebClient client = WebClient.create("http://localhost:7634");

    private final RedisConnectionFactory redisConnectionFactory;
    private final RedisOperations<String, Aircraft> redisOperations;

    public PlaneFinderPoller(RedisConnectionFactory redisConnectionFactory, RedisOperations<String, Aircraft> redisOperations) {
        this.redisConnectionFactory = redisConnectionFactory;
        this.redisOperations = redisOperations;
    }

    @Scheduled(fixedRate = 1000)
    private void pollPlanes() {
        System.out.println(">> Polling");

        // Redis DB 전체 데이터 삭제
        redisConnectionFactory.getConnection().serverCommands().flushDb();

        //  WebClient 세부 파라미터 설정하기
        //       .uri(uriBuilder -> uriBuilder
        //          .queryParam("altitude", "10000")
        //          .queryParam("range", "500")
        //          .build())

        //  WebClient 파라미터 입력하기
        //       .uri("/aircraft/{id}", id)

        client.get()
                .uri("/aircraft") // 엔드포인트 추가
                .retrieve() // REST API 호출
                .bodyToFlux(Aircraft.class) // Flux<Aircraft> 형태로 Response 수신
                .filter(plane -> !plane.getReg().isEmpty()) // reg 속성값이 존재하는 경우만 필터링
                .toStream()
                .forEach(ac -> redisOperations.opsForValue().set(ac.getReg(), ac)); // redis DB 환경에 값 저장

        redisOperations.opsForValue()
                .getOperations()
                .keys("*") // 모든 Key 값 호출
                .forEach(ac -> System.out.println(redisOperations.opsForValue().get(ac)));
    }

}
