package kr.ejsoft.lecture.chap10.orderservice;

import org.springframework.boot.SpringApplication;

public class TestChap10OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication
                .from(Chap10OrderServiceApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }

}
