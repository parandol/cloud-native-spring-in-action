package kr.ejsoft.lecture.chap10.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Chap10OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap10OrderServiceApplication.class, args);
    }

}
