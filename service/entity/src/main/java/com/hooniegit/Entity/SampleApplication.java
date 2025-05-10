package com.hooniegit.Entity;

import com.hooniegit.Entity.Configurations.Droid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SampleApplication {

    /**
     * 1. Spring Boot Application 환경 설정 확인
     * 2. Spring Boot Application 설정
     * 3. Initial Context 생성
     * 4. Spring Application 실행
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    /**
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "droid")
    Droid createDroid() {
        return new Droid();
    }

}