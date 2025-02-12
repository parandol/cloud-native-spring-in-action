package kr.ejsoft.lecture.chap12.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Chap12OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap12OrderServiceApplication.class, args);
    }

}
