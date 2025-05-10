package com.hooniegit.Entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}