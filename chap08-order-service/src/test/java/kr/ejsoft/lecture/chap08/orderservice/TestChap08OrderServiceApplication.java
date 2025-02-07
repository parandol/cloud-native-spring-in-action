package kr.ejsoft.lecture.chap08.orderservice;

import org.springframework.boot.SpringApplication;

public class TestChap08OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(Chap08OrderServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
