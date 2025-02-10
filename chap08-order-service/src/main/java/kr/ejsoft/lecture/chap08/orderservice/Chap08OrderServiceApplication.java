package kr.ejsoft.lecture.chap08.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Chap08OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap08OrderServiceApplication.class, args);
    }

}
