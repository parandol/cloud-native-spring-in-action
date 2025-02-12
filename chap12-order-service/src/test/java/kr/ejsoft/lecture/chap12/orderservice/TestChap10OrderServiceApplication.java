package kr.ejsoft.lecture.chap12.orderservice;

import org.springframework.boot.SpringApplication;

public class TestChap10OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication
                .from(Chap12OrderServiceApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }

}
