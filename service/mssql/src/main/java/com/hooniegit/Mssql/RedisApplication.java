package com.hooniegit.Redis;

//import com.hooniegit.Redis.Datas.Aircraft;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class RedisApplication {

    /**
     * RedisOperations :: Redis 와 상호작용하기 위해 필요한 기능 지정
     * @param connectionFactory
     * @return
     */
//    @Bean
//    public RedisOperations<String, Aircraft> redisOperations(RedisConnectionFactory connectionFactory) {
//        Jackson2JsonRedisSerializer<Aircraft> serializer = new Jackson2JsonRedisSerializer<>(Aircraft.class);
//
//        // RedisTemplate :: RedisOperarions 인터페이스 구현
//        RedisTemplate<String, Aircraft> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        redisTemplate.setDefaultSerializer(serializer);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//
//        return redisTemplate;
//    }

    /**
     * 1. Spring Boot Application 환경 설정 확인
     * 2. Spring Boot Application 설정
     * 3. Initial Context 생성
     * 4. Spring Application 실행
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}